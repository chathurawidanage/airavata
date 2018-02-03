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
 * The primary key class for the app_module_mapping database table.
 * 
 */
public class AppModuleMappingPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="INTERFACE_ID", insertable=false, updatable=false)
	@Id
	private String interfaceId;

	@Column(name="MODULE_ID", insertable=false, updatable=false)
	@Id
	private String moduleId;

	public AppModuleMappingPK() {
	}

	public String getInterfaceId() {
		return interfaceId;
	}

	public void setInterfaceId(String interfaceId) {
		this.interfaceId = interfaceId;
	}

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AppModuleMappingPK)) {
			return false;
		}
		AppModuleMappingPK castOther = (AppModuleMappingPK)other;
		return 
			this.interfaceId.equals(castOther.interfaceId)
			&& this.moduleId.equals(castOther.moduleId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.interfaceId.hashCode();
		hash = hash * prime + this.moduleId.hashCode();
		
		return hash;
	}
}