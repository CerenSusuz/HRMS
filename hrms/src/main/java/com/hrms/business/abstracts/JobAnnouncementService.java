package com.hrms.business.abstracts;

import java.util.List;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.JobAnnouncement;

public interface JobAnnouncementService {
	
	DataResult<List<JobAnnouncement>> getAll();
	Result add(JobAnnouncement jobAnnouncement);
	
	DataResult<List<JobAnnouncement>> getByIsActiveTrue();
}
