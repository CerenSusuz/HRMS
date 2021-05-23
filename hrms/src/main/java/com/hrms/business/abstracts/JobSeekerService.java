package com.hrms.business.abstracts;

import java.util.List;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
	DataResult<List<JobSeeker>> getAll();
	DataResult<JobSeeker> getByNationalityId(String nationalityId);
	Result add(JobSeeker jobSeeker);
}
