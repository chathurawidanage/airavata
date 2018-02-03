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
package org.apache.airavata.registry.core.entities.appcatalog;

import javax.persistence.Column;
import java.io.Serializable;
import javax.persistence.Id;

/**
 * The primary key class for the postjob_command database table.
 */
public class PostjobCommandPK implements Serializable {
    // default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;

    @Column(name = "APPDEPLOYMENT_ID", insertable = false, updatable = false)
    @Id
    private String appdeploymentId;

    @Column(name = "COMMAND")
    @Id
    private String command;

    public PostjobCommandPK() {
    }

    public String getAppdeploymentId() {
        return appdeploymentId;
    }

    public void setAppdeploymentId(String appdeploymentId) {
        this.appdeploymentId = appdeploymentId;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PostjobCommandPK)) {
            return false;
        }
        PostjobCommandPK castOther = (PostjobCommandPK) other;
        return this.appdeploymentId.equals(castOther.appdeploymentId) && this.command.equals(castOther.command);
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + this.appdeploymentId.hashCode();
        hash = hash * prime + this.command.hashCode();

        return hash;
    }
}