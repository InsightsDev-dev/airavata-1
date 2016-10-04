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
package org.apache.airavata.sharing.registry.db.repositories;

import org.apache.airavata.sharing.registry.db.entities.SharingEntity;
import org.apache.airavata.sharing.registry.db.entities.SharingEntityPK;
import org.apache.airavata.sharing.registry.db.utils.DBConstants;
import org.apache.airavata.sharing.registry.models.GovRegistryException;
import org.apache.airavata.sharing.registry.models.Sharing;
import org.apache.airavata.sharing.registry.models.SharingType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;

public class SharingRepository extends AbstractRepository<Sharing, SharingEntity, SharingEntityPK> {
    private final static Logger logger = LoggerFactory.getLogger(SharingRepository.class);

    public SharingRepository() {
        super(Sharing.class, SharingEntity.class);
    }

    public List<Sharing> getIndirectSharedChildren(String parentId, String permissionTypeId) throws GovRegistryException {
        HashMap<String, String> filters = new HashMap<>();
        filters.put(DBConstants.SharingTable.INHERITED_PARENT_ID, parentId);
        filters.put(DBConstants.SharingTable.SHARING_TYPE, SharingType.INHERITED.toString());
        filters.put(DBConstants.SharingTable.PERMISSION_TYPE_ID, permissionTypeId);

        return select(filters, 0, -1);
    }

    public List<Sharing> getPermissionsForEntity(String entityId) throws GovRegistryException {
        HashMap<String, String> filters = new HashMap<>();
        filters.put(DBConstants.SharingTable.ENTITY_ID, entityId);
        return select(filters, 0, -1);
    }
}