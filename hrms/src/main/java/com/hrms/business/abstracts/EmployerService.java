package com.hrms.business.abstracts;

import java.util.List;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.Employer;
import com.hrms.entities.concretes.JobSeeker;

public interface EmployerService {
	DataResult<List<Employer>> getAll();
	Result add(Employer employer);
}
