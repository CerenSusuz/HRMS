package com.hrms.business.abstracts;

import java.util.List;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.Employer;

public interface EmployerService {
	DataResult<List<Employer>> getAll();
	Result add(Employer employer);
	//delete
	//update
}
