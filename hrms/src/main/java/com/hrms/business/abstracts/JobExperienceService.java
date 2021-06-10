package com.hrms.business.abstracts;

import java.util.List;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.JobExperience;

public interface JobExperienceService {
	Result add(JobExperience jobExperience);
	DataResult<List<JobExperience>> getAll();
	DataResult<List<JobExperience>> getByJobSeekerIdOrderByDateOfEndASC(int jobSeeker_id);
	DataResult<List<JobExperience>> getByJobSeekerIdOrderByDateOfEndDESC(int jobSeeker_id);
	//delete
	//update
}
