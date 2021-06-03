package com.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hrms.business.abstracts.JobExperienceService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.ErrorDataResult;
import com.hrms.core.utilities.results.ErrorResult;
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
		var result = this.jobExperienceDao.save(jobExperience);
		
		if (result != null) {
			return new SuccessResult("job Experience add ok");
		}
		return new ErrorResult("job Experience add NOT ok");
	}

	@Override
	public DataResult<List<JobExperience>> getAll() {
		var result = this.jobExperienceDao.findAll();
		
		if (result != null) {
			return new SuccessDataResult<List<JobExperience>>(result);
		}
		return new ErrorDataResult<List<JobExperience>>("job experiences getAll NOT ok");
	}

	@Override
	public DataResult<List<JobExperience>> getByJobSeekerIdOrderByDateOfEndASC(int jobSeeker_id) {
		Sort sortBy = Sort.by(Sort.Direction.ASC,"dateOfEnd");
		
		var result = this.jobExperienceDao.getByJobSeekerId(sortBy,jobSeeker_id);
		if ( result != null) {
			return new SuccessDataResult<List<JobExperience>>(result,"asc sorted ok");
		}
		return new ErrorDataResult<List<JobExperience>>("asc sorted NOT ok");
	}

	@Override
	public DataResult<List<JobExperience>> getByJobSeekerIdOrderByDateOfEndDESC(int jobSeeker_id) {
		Sort sortBy = Sort.by(Sort.Direction.DESC,"dateOfEnd");
		
		var result = this.jobExperienceDao.getByJobSeekerId(sortBy,jobSeeker_id);
		if(result != null){
			return new SuccessDataResult<List<JobExperience>>(result,"desc sorted ok");
			}
		return new ErrorDataResult<List<JobExperience>>("desc sorted NOT ok");
	}
	
	
}
