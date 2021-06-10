package com.hrms.business.abstracts;

import java.util.List;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.JobSeeker;
import com.hrms.entities.dtos.CVDto;

public interface JobSeekerService {
	DataResult<List<JobSeeker>> getAll();
	DataResult<JobSeeker> getByNationalityId(String nationalityId);
	DataResult<CVDto> getCvById(int id);
	DataResult<JobSeeker> getById(int id);
	Result add(JobSeeker jobSeeker);
	//delete
	//update
}
