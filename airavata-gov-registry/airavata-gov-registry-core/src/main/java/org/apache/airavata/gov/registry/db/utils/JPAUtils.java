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
package org.apache.airavata.gov.registry.db.utils;

import org.apache.airavata.common.exception.ApplicationSettingsException;
import org.apache.airavata.common.utils.ServerSettings;
import org.apache.airavata.gov.registry.models.GovRegistryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

public class JPAUtils {
    private final static Logger logger = LoggerFactory.getLogger(JPAUtils.class);

    private static final String PERSISTENCE_UNIT_NAME = "appcatalog_data";
    private static final String GOV_REG_JDBC_DRIVER = "appcatalog.jdbc.driver";
    private static final String GOV_REG_JDBC_URL = "appcatalog.jdbc.url";
    private static final String GOV_REG_JDBC_USER = "appcatalog.jdbc.user";
    private static final String GOV_REG_JDBC_PWD = "appcatalog.jdbc.password";
    private static final String GOV_REG_VALIDATION_QUERY = "appcatalog.validationQuery";
    private static final String JPA_CACHE_SIZE = "jpa.cache.size";
    private static final String JPA_CACHE_ENABLED = "cache.enable";

    @PersistenceUnit(unitName = "airavata-gov-registry")
    protected static EntityManagerFactory factory;
    @PersistenceContext(unitName = "airavata-gov-registry")
    private static EntityManager appCatEntityManager;

    public static EntityManager getEntityManager() {
        if (factory == null) {
//            String connectionProperties = "DriverClassName=" + readServerProperties(GOV_REG_JDBC_DRIVER) + "," +
//                    "Url=" + readServerProperties(GOV_REG_JDBC_URL) + "?autoReconnect=true," +
//                    "Username=" + readServerProperties(GOV_REG_JDBC_USER) + "," +
//                    "Password=" + readServerProperties(GOV_REG_JDBC_PWD) +
//                    ",validationQuery=" + readServerProperties(GOV_REG_VALIDATION_QUERY);
//
            String connectionProperties = "jdbc:mysql://localhost:3306/airavata_gov_registry;create=true;user=root;password=";

            Map<String, String> properties = new HashMap<String, String>();
            properties.put("openjpa.ConnectionDriverName", "org.apache.commons.dbcp.BasicDataSource");
            properties.put("openjpa.ConnectionProperties", connectionProperties);
            properties.put("openjpa.DynamicEnhancementAgent", "true");
            properties.put("openjpa.RuntimeUnenhancedClasses", "unsupported");
            // For app catalog, we don't need caching
//            properties.put("openjpa.DataCache","" + readServerProperties(JPA_CACHE_ENABLED) + "(CacheSize=" + Integer.valueOf(readServerProperties(JPA_CACHE_SIZE)) + ", SoftReferenceSize=0)");
//            properties.put("openjpa.QueryCache","" + readServerProperties(JPA_CACHE_ENABLED) + "(CacheSize=" + Integer.valueOf(readServerProperties(JPA_CACHE_SIZE)) + ", SoftReferenceSize=0)");
            properties.put("openjpa.RemoteCommitProvider", "sjvm");
            properties.put("openjpa.Log", "DefaultLevel=INFO, Runtime=INFO, Tool=INFO, SQL=INFO");
            properties.put("openjpa.jdbc.SynchronizeMappings", "buildSchema(ForeignKeys=true)");
            properties.put("openjpa.jdbc.QuerySQLCache", "false");
            properties.put("openjpa.ConnectionFactoryProperties", "PrettyPrint=true, PrettyPrintLineLength=72," +
                    " PrintParameters=true, MaxActive=10, MaxIdle=5, MinIdle=2, MaxWait=31536000,  autoReconnect=true");
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME, properties);
        }
        appCatEntityManager = factory.createEntityManager();
        return appCatEntityManager;
    }

    private static String readServerProperties(String propertyName) throws GovRegistryException {
        try {
            return ServerSettings.getSetting(propertyName);
        } catch (ApplicationSettingsException e) {
            logger.error("Unable to read airavata-server.properties...", e);
            throw new GovRegistryException("Unable to read airavata-server.properties...");
        }
    }

    public static <R> R execute(Committer<EntityManager, R> committer) throws GovRegistryException {
        EntityManager entityManager = JPAUtils.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            R r = committer.commit(entityManager);
            entityManager.getTransaction().commit();
            return  r;
        }finally {
            if (entityManager != null && entityManager.isOpen()) {
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
                entityManager.close();
            }
        }
    }
}