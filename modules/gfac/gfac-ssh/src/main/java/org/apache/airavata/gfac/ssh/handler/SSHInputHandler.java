/*
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
*/
package org.apache.airavata.gfac.ssh.handler;

import java.io.File;
import java.io.IOException;
import java.util.*;

import org.apache.airavata.common.exception.ApplicationSettingsException;
import org.apache.airavata.common.utils.StringUtil;
import org.apache.airavata.commons.gfac.type.ActualParameter;
import org.apache.airavata.commons.gfac.type.MappingFactory;
import org.apache.airavata.gfac.GFacException;
import org.apache.airavata.gfac.core.context.JobExecutionContext;
import org.apache.airavata.gfac.core.context.MessageContext;
import org.apache.airavata.gfac.core.handler.AbstractHandler;
import org.apache.airavata.gfac.core.handler.GFacHandlerException;
import org.apache.airavata.gfac.core.utils.GFacUtils;
import org.apache.airavata.gfac.ssh.security.SSHSecurityContext;
import org.apache.airavata.gfac.ssh.util.GFACSSHUtils;
import org.apache.airavata.gsi.ssh.api.Cluster;
import org.apache.airavata.gsi.ssh.api.SSHApiException;
import org.apache.airavata.model.workspace.experiment.CorrectiveAction;
import org.apache.airavata.model.workspace.experiment.DataTransferDetails;
import org.apache.airavata.model.workspace.experiment.ErrorCategory;
import org.apache.airavata.model.workspace.experiment.TransferState;
import org.apache.airavata.model.workspace.experiment.TransferStatus;
import org.apache.airavata.registry.cpi.ChildDataType;
import org.apache.airavata.schemas.gfac.ApplicationDeploymentDescriptionType;
import org.apache.airavata.schemas.gfac.URIArrayType;
import org.apache.airavata.schemas.gfac.URIParameterType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SSHInputHandler extends AbstractHandler {

    private static final Logger log = LoggerFactory.getLogger(SSHInputHandler.class);


    public void invoke(JobExecutionContext jobExecutionContext) throws GFacHandlerException {
        DataTransferDetails detail = new DataTransferDetails();
        TransferStatus status = new TransferStatus();
        int index = 0;
        int oldIndex = 0;
        List<String> oldFiles = new ArrayList<String>();
        StringBuffer data = new StringBuffer("|");
        MessageContext inputNew = new MessageContext();
        Cluster cluster = null;
        
        try {
            String hostAddress = jobExecutionContext.getHostName();
            if (jobExecutionContext.getSecurityContext(hostAddress) == null) {
                try {
                    GFACSSHUtils.addSecurityContext(jobExecutionContext);
                } catch (ApplicationSettingsException e) {
                    log.error(e.getMessage());
                    try {
         				GFacUtils.saveErrorDetails(jobExecutionContext, e.getLocalizedMessage(), CorrectiveAction.CONTACT_SUPPORT, ErrorCategory.AIRAVATA_INTERNAL_ERROR);
         			} catch (GFacException e1) {
         				 log.error(e1.getLocalizedMessage());
         			}
                    throw new GFacHandlerException("Error while creating SSHSecurityContext", e, e.getLocalizedMessage());
                }
            }
            log.info("Invoking SCPInputHandler");
            super.invoke(jobExecutionContext);


            MessageContext input = jobExecutionContext.getInMessageContext();
            Set<String> parameters = input.getParameters().keySet();
            for (String paramName : parameters) {
                ActualParameter actualParameter = (ActualParameter) input.getParameters().get(paramName);
                String paramValue = MappingFactory.toString(actualParameter);
                //TODO: Review this with type
                if ("URI".equals(actualParameter.getType().getType().toString())) {
                	if (index < oldIndex) {
                        log.info("Input File: " + paramValue + " is already transfered, so we skip this operation !!!");
                        ((URIParameterType) actualParameter.getType()).setValue(oldFiles.get(index));
                        data.append(oldFiles.get(index++)).append(","); // we get already transfered file and increment the index
                    }else{
                	String stageInputFile = stageInputFiles(cluster,jobExecutionContext, paramValue);
                    ((URIParameterType) actualParameter.getType()).setValue(stageInputFile);
                    StringBuffer temp = new StringBuffer(data.append(stageInputFile).append(",").toString());
                    
                    status.setTransferState(TransferState.UPLOAD);
                    detail.setTransferStatus(status);
                    detail.setTransferDescription("Input Data Staged: " + stageInputFile);
                    registry.add(ChildDataType.DATA_TRANSFER_DETAIL, detail, jobExecutionContext.getTaskData().getTaskID());
                    GFacUtils.savePluginData(jobExecutionContext, temp.insert(0, ++index), this.getClass().getName());
                    }
                } else if ("URIArray".equals(actualParameter.getType().getType().toString())) {
                	if (index < oldIndex) {
                        log.info("Input File: " + paramValue + " is already transfered, so we skip this operation !!!");
                        ((URIParameterType) actualParameter.getType()).setValue(oldFiles.get(index));
                        data.append(oldFiles.get(index++)).append(","); // we get already transfered file and increment the index
                    }else{
                	List<String> split = Arrays.asList(StringUtil.getElementsFromString(paramValue));
                    List<String> newFiles = new ArrayList<String>();
                    for (String paramValueEach : split) {
                        String stageInputFiles = stageInputFiles(cluster,jobExecutionContext, paramValueEach);
                        status.setTransferState(TransferState.UPLOAD);
                        detail.setTransferStatus(status);
                        detail.setTransferDescription("Input Data Staged: " + stageInputFiles);
                        registry.add(ChildDataType.DATA_TRANSFER_DETAIL, detail, jobExecutionContext.getTaskData().getTaskID());
                        newFiles.add(stageInputFiles);
                        StringBuffer temp = new StringBuffer(data.append(stageInputFiles).append(",").toString());
                        GFacUtils.savePluginData(jobExecutionContext, temp.insert(0, ++index), this.getClass().getName());
                    }
                    ((URIArrayType) actualParameter.getType()).setValueArray(newFiles.toArray(new String[newFiles.size()]));
                    }
                }
                inputNew.getParameters().put(paramName, actualParameter);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            status.setTransferState(TransferState.FAILED);
            detail.setTransferStatus(status);
            try {
                GFacUtils.saveErrorDetails(jobExecutionContext, e.getLocalizedMessage(), CorrectiveAction.CONTACT_SUPPORT, ErrorCategory.FILE_SYSTEM_FAILURE);
                registry.add(ChildDataType.DATA_TRANSFER_DETAIL, detail, jobExecutionContext.getTaskData().getTaskID());
            } catch (Exception e1) {
                throw new GFacHandlerException("Error persisting status", e1, e1.getLocalizedMessage());
            }
            throw new GFacHandlerException("Error while input File Staging", e, e.getLocalizedMessage());
        }
        jobExecutionContext.setInMessageContext(inputNew);
    }

    private static String stageInputFiles(Cluster cluster, JobExecutionContext jobExecutionContext, String paramValue) throws IOException, GFacException {
        int i = paramValue.lastIndexOf(File.separator);
        String substring = paramValue.substring(i + 1);
        try {
            String targetFile = jobExecutionContext.getInputDir() + File.separator + substring;
            if(paramValue.startsWith("scp:")){
            	paramValue = paramValue.substring(paramValue.indexOf(":") + 1, paramValue.length());
            	cluster.scpThirdParty(paramValue, targetFile);
            }else{
            if(paramValue.startsWith("file")){
                paramValue = paramValue.substring(paramValue.indexOf(":") + 1, paramValue.length());
            }
            boolean success = false;
            int j = 1;
            while(!success){
            try {
				cluster.scpTo(targetFile, paramValue);
				success = true;
			} catch (Exception e) {
				log.info(e.getLocalizedMessage());
				Thread.sleep(2000);
				 if(j==3) {
					throw new GFacHandlerException("Error while input File Staging", e, e.getLocalizedMessage());
				 }
            }
            j++;
            }
            }
            return targetFile;
        } catch (Exception e) {
            throw new GFacHandlerException("Error while input File Staging", e, e.getLocalizedMessage());
        }
    }

    public void initProperties(Properties properties) throws GFacHandlerException {

    }
}
