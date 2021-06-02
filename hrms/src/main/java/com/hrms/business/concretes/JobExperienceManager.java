package com.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hrms.business.abstracts.JobExperienceService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dataAccess.abstracts.JobExperienceDao;
import com.hrms.entities.concretes.JobExperience;

@Service
public class JobExperienceManager implements JobExperienceService {

	private JobExperienceDao jobExperienceDao;
	
	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao) {
		super();
		this.jobExperienceDao = jobExperienceDao;
	}

	@Override
	public Result add(JobExperience jobExperience) {
		this.jobExperienceDao.save(jobExperience);
		return new SuccessResult("job Experience add ok");
	}

	@Override
	public DataResult<List<JobExperience>> getAll() {
		return new SuccessDataResult<List<JobExperience>>
		(this.jobExperienceDao.findAll());
	}

	@Override
	public DataResult<List<JobExperience>> getByJobSeekerIdOrderByDateOfEndASC(int jobSeeker_id) {
		Sort sortBy = Sort.by(Sort.Direction.ASC,"dateOfEnd");
		return new SuccessDataResult<List<JobExperience>>
		(this.jobExperienceDao.getByJobSeekerId(sortBy,jobSeeker_id),"asc sorted ok");
	}

	@Override
	public DataResult<List<JobExperience>> getByJobSeekerIdOrderByDateOfEndDESC(int jobSeeker_id) {
		Sort sortBy = Sort.by(Sort.Direction.DESC,"dateOfEnd");
		return new SuccessDataResult<List<JobExperience>>
		(this.jobExperienceDao.getByJobSeekerId(sortBy,jobSeeker_id),"desc sorted ok");
	}
	
	
}
