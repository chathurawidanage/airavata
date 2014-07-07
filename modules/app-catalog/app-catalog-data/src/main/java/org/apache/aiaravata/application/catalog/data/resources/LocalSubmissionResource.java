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

package org.apache.aiaravata.application.catalog.data.resources;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.airavata.appcatalog.cpi.AppCatalogException;
import org.apache.aiaravata.application.catalog.data.model.LocalSubmission;
import org.apache.aiaravata.application.catalog.data.model.ResourceJobManager;
import org.apache.aiaravata.application.catalog.data.util.AppCatalogJPAUtils;
import org.apache.aiaravata.application.catalog.data.util.AppCatalogQueryGenerator;
import org.apache.aiaravata.application.catalog.data.util.AppCatalogResourceType;
import org.apache.airavata.common.exception.ApplicationSettingsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocalSubmissionResource extends AbstractResource {
	private final static Logger logger = LoggerFactory.getLogger(LocalSubmissionResource.class);
	private String resourceJobManagerId;
	private ResourceJobManagerResource resourceJobManagerResource;
	private String jobSubmissionInterfaceId;
	
	@Override
	public void remove(Object identifier) throws AppCatalogException {
		EntityManager em = null;
		try {
			em = AppCatalogJPAUtils.getEntityManager();
			em.getTransaction().begin();
			AppCatalogQueryGenerator generator = new AppCatalogQueryGenerator(LOCAL_SUBMISSION);
			generator.setParameter(LocalSubmissionConstants.JOB_SUBMISSION_INTERFACE_ID, identifier);
			Query q = generator.deleteQuery(em);
			q.executeUpdate();
			em.getTransaction().commit();
			em.close();
		} catch (ApplicationSettingsException e) {
			logger.error(e.getMessage(), e);
			throw new AppCatalogException(e);
		} finally {
			if (em != null && em.isOpen()) {
				if (em.getTransaction().isActive()) {
					em.getTransaction().rollback();
				}
				em.close();
			}
		}
	}
	
	@Override
	public Resource get(Object identifier) throws AppCatalogException {
		EntityManager em = null;
		try {
			em = AppCatalogJPAUtils.getEntityManager();
			em.getTransaction().begin();
			AppCatalogQueryGenerator generator = new AppCatalogQueryGenerator(LOCAL_SUBMISSION);
			generator.setParameter(LocalSubmissionConstants.JOB_SUBMISSION_INTERFACE_ID, identifier);
			Query q = generator.selectQuery(em);
			LocalSubmission localSubmission = (LocalSubmission) q.getSingleResult();
			LocalSubmissionResource localSubmissionResource = (LocalSubmissionResource) AppCatalogJPAUtils.getResource(AppCatalogResourceType.LOCAL_SUBMISSION, localSubmission);
			em.getTransaction().commit();
			em.close();
			return localSubmissionResource;
		} catch (ApplicationSettingsException e) {
			logger.error(e.getMessage(), e);
			throw new AppCatalogException(e);
		} finally {
			if (em != null && em.isOpen()) {
				if (em.getTransaction().isActive()) {
					em.getTransaction().rollback();
				}
				em.close();
			}
		}
	}
	
	@Override
	public List<Resource> get(String fieldName, Object value) throws AppCatalogException {
		List<Resource> localSubmissionResources = new ArrayList<Resource>();
		EntityManager em = null;
		try {
			em = AppCatalogJPAUtils.getEntityManager();
			em.getTransaction().begin();
			AppCatalogQueryGenerator generator = new AppCatalogQueryGenerator(LOCAL_SUBMISSION);
			Query q;
			if ((fieldName.equals(LocalSubmissionConstants.RESOURCE_JOB_MANAGER_ID)) || (fieldName.equals(LocalSubmissionConstants.JOB_SUBMISSION_INTERFACE_ID))) {
				generator.setParameter(fieldName, value);
				q = generator.selectQuery(em);
				List<?> results = q.getResultList();
				for (Object result : results) {
					LocalSubmission localSubmission = (LocalSubmission) result;
					LocalSubmissionResource localSubmissionResource = (LocalSubmissionResource) AppCatalogJPAUtils.getResource(AppCatalogResourceType.LOCAL_SUBMISSION, localSubmission);
					localSubmissionResources.add(localSubmissionResource);
				}
			} else {
				em.getTransaction().commit();
					em.close();
				logger.error("Unsupported field name for Local Submission Resource.", new IllegalArgumentException());
				throw new IllegalArgumentException("Unsupported field name for Local Submission Resource.");
			}
			em.getTransaction().commit();
			em.close();
		} catch (ApplicationSettingsException e) {
			logger.error(e.getMessage(), e);
			throw new AppCatalogException(e);
		} finally {
			if (em != null && em.isOpen()) {
				if (em.getTransaction().isActive()) {
					em.getTransaction().rollback();
				}
				em.close();
			}
		}
		return localSubmissionResources;
	}

    @Override
    public List<Resource> getAll() throws AppCatalogException {
        return null;
    }

    @Override
    public List<String> getAllIds() throws AppCatalogException {
        return null;
    }

    @Override
	public List<String> getIds(String fieldName, Object value) throws AppCatalogException {
		List<String> localSubmissionResourceIDs = new ArrayList<String>();
		EntityManager em = null;
		try {
			em = AppCatalogJPAUtils.getEntityManager();
			em.getTransaction().begin();
			AppCatalogQueryGenerator generator = new AppCatalogQueryGenerator(LOCAL_SUBMISSION);
			Query q;
			if ((fieldName.equals(LocalSubmissionConstants.RESOURCE_JOB_MANAGER_ID)) || (fieldName.equals(LocalSubmissionConstants.JOB_SUBMISSION_INTERFACE_ID))) {
				generator.setParameter(fieldName, value);
				q = generator.selectQuery(em);
				List<?> results = q.getResultList();
				for (Object result : results) {
					LocalSubmission localSubmission = (LocalSubmission) result;
					LocalSubmissionResource localSubmissionResource = (LocalSubmissionResource) AppCatalogJPAUtils.getResource(AppCatalogResourceType.LOCAL_SUBMISSION, localSubmission);
					localSubmissionResourceIDs.add(localSubmissionResource.getJobSubmissionInterfaceId());
				}
			} else {
				em.getTransaction().commit();
					em.close();
				logger.error("Unsupported field name for Local Submission Resource.", new IllegalArgumentException());
				throw new IllegalArgumentException("Unsupported field name for Local Submission Resource.");
			}
			em.getTransaction().commit();
			em.close();
		} catch (ApplicationSettingsException e) {
			logger.error(e.getMessage(), e);
			throw new AppCatalogException(e);
		} finally {
			if (em != null && em.isOpen()) {
				if (em.getTransaction().isActive()) {
					em.getTransaction().rollback();
				}
				em.close();
			}
		}
		return localSubmissionResourceIDs;
	}
	
	@Override
	public void save() throws AppCatalogException {
		EntityManager em = null;
		try {
			em = AppCatalogJPAUtils.getEntityManager();
			LocalSubmission existingLocalSubmission = em.find(LocalSubmission.class, jobSubmissionInterfaceId);
			em.close();
			LocalSubmission localSubmission;
			em = AppCatalogJPAUtils.getEntityManager();
			em.getTransaction().begin();
			if (existingLocalSubmission == null) {
				localSubmission = new LocalSubmission();
			} else {
				localSubmission = existingLocalSubmission;
			}
			localSubmission.setResourceJobManagerId(getResourceJobManagerId());
			ResourceJobManager resourceJobManager = em.find(ResourceJobManager.class, getResourceJobManagerId());
			localSubmission.setResourceJobManager(resourceJobManager);
			localSubmission.setJobSubmissionInterfaceId(getJobSubmissionInterfaceId());
			if (existingLocalSubmission == null) {
				em.persist(localSubmission);
			} else {
				em.merge(localSubmission);
			}
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new AppCatalogException(e);
		} finally {
			if (em != null && em.isOpen()) {
				if (em.getTransaction().isActive()) {
					em.getTransaction().rollback();
				}
				em.close();
			}
		}
	}
	
	@Override
	public boolean isExists(Object identifier) throws AppCatalogException {
		EntityManager em = null;
		try {
			em = AppCatalogJPAUtils.getEntityManager();
			LocalSubmission localSubmission = em.find(LocalSubmission.class, identifier);
			em.close();
			return localSubmission != null;
		} catch (ApplicationSettingsException e) {
			logger.error(e.getMessage(), e);
			throw new AppCatalogException(e);
		} finally {
			if (em != null && em.isOpen()) {
				if (em.getTransaction().isActive()) {
					em.getTransaction().rollback();
				}
				em.close();
			}
		}
	}
	
	public String getResourceJobManagerId() {
		return resourceJobManagerId;
	}
	
	public ResourceJobManagerResource getResourceJobManagerResource() {
		return resourceJobManagerResource;
	}
	
	public String getJobSubmissionInterfaceId() {
		return jobSubmissionInterfaceId;
	}
	
	public void setResourceJobManagerId(String resourceJobManagerId) {
		this.resourceJobManagerId=resourceJobManagerId;
	}
	
	public void setResourceJobManagerResource(ResourceJobManagerResource resourceJobManagerResource) {
		this.resourceJobManagerResource=resourceJobManagerResource;
	}
	
	public void setJobSubmissionInterfaceId(String jobSubmissionInterfaceId) {
		this.jobSubmissionInterfaceId=jobSubmissionInterfaceId;
	}
}
