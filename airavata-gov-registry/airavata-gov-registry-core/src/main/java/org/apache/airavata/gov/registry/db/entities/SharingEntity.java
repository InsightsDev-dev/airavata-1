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
package org.apache.airavata.gov.registry.db.entities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;

@Entity
@Table(name = "SHARING", schema = "")
@IdClass(SharingEntityPK.class)
public class SharingEntity {
    private final static Logger logger = LoggerFactory.getLogger(SharingEntity.class);
    private String permissionTypeId;
    private String entityId;
    private String groupId;
    private PermissionTypeEntity permissionTypeByPermissionTypeId;
    private EntityTypeEntity entityTypeByEntityTypeId;

    @Id
    @Column(name = "PERMISSION_TYPE_ID")
    public String getPermissionTypeId() {
        return permissionTypeId;
    }

    public void setPermissionTypeId(String permissionTypeId) {
        this.permissionTypeId = permissionTypeId;
    }

    @Id
    @Column(name = "ENTITY_ID")
    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    @Id
    @Column(name = "GROUP_ID")
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SharingEntity that = (SharingEntity) o;

        if (permissionTypeId != null ? !permissionTypeId.equals(that.permissionTypeId) : that.permissionTypeId != null)
            return false;
        if (entityId != null ? !entityId.equals(that.entityId) : that.entityId != null) return false;
        if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = permissionTypeId != null ? permissionTypeId.hashCode() : 0;
        result = 31 * result + (entityId != null ? entityId.hashCode() : 0);
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "PERMISSION_TYPE_ID", referencedColumnName = "PERMISSION_TYPE_ID", nullable = false)
    public PermissionTypeEntity getPermissionTypeByPermissionTypeId() {
        return permissionTypeByPermissionTypeId;
    }

    public void setPermissionTypeByPermissionTypeId(PermissionTypeEntity permissionTypeByPermissionTypeId) {
        this.permissionTypeByPermissionTypeId = permissionTypeByPermissionTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "ENTITY_TYPE_ID", referencedColumnName = "ENTITY_TYPE_ID")
    public EntityTypeEntity getEntityTypeByEntityTypeId() {
        return entityTypeByEntityTypeId;
    }

    public void setEntityTypeByEntityTypeId(EntityTypeEntity entityTypeByEntityTypeId) {
        this.entityTypeByEntityTypeId = entityTypeByEntityTypeId;
    }
}