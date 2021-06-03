package com.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.business.abstracts.JobSeekerService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.ErrorDataResult;
import com.hrms.core.utilities.results.ErrorResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dataAccess.abstracts.JobSeekerDao;
import com.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		var result = this.jobSeekerDao.findAll();
		if (result != null) {
			return new SuccessDataResult<List<JobSeeker>>(result,"Job Seekers listed");	
		}
		return new ErrorDataResult<List<JobSeeker>>("Job Seekers NOT listed");	
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		var result = this.jobSeekerDao.save(jobSeeker);
		if (result != null) {
			return new SuccessResult("Job Seeker Add OK");
		}
		return new ErrorResult("Job Seeker Add NOT OK");
	}

	@Override
	public DataResult<JobSeeker> getByNationalityId(String nationalityId) {
		var result = this.jobSeekerDao.getByNationalityId(nationalityId);
		if (result != null) {
			return new SuccessDataResult<JobSeeker>("User founded");
		}
		return new ErrorDataResult<JobSeeker>("User NOT founded");
	}

}
