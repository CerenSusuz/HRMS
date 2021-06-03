package com.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.business.abstracts.EmployerService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.ErrorDataResult;
import com.hrms.core.utilities.results.ErrorResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dataAccess.abstracts.EmployerDao;
import com.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		var result = this.employerDao.findAll();
		if (result != null) {
			return new SuccessDataResult<List<Employer>>(result,"Employers listed");	
		}
		return new ErrorDataResult<List<Employer>>("Employers listed");	
	}

	@Override
	public Result add(Employer employer) {
		var result = this.employerDao.save(employer);
		if (result != null) {
			return new SuccessResult("Employer Add OK");
		}
		return new ErrorResult("Employer Add NOT OK");
	}

}
