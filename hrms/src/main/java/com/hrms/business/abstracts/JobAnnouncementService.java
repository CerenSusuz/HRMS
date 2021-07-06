package com.hrms.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.JobAnnouncement;

public interface JobAnnouncementService {
	
	DataResult<List<JobAnnouncement>> getAll();
	Result add(JobAnnouncement jobAnnouncement);
	DataResult<JobAnnouncement> changeStatus(int employerId,int announcementId, boolean status);
	DataResult<List<JobAnnouncement>> getByIsActiveTrue();
	DataResult<List<JobAnnouncement>> getByApplicationDeadlineLessThanEqual(LocalDate date);
	DataResult<List<JobAnnouncement>> getByIsActiveTrueAndApplicationDeadlineLessThanEqual(LocalDate date);
	DataResult<List<JobAnnouncement>> getByIsActiveTrueAndEmployer_CompanyName(String companyName);
	DataResult<List<JobAnnouncement>> getByEmployerId(int id);
	DataResult<List<JobAnnouncement>> getByIsActiveTrueAndCity_Id(int id);
	DataResult<List<JobAnnouncement>> getByIsActiveTrueAndDepartment_Id(int id);
	DataResult<JobAnnouncement> getById(int id);
	
}
