package com.hrms.business.abstracts;


import com.hrms.core.utilities.results.Result;
import com.hrms.entities.dtos.EmployerForRegisterDto;
import com.hrms.entities.dtos.JobSeekerForRegisterDto;

public interface AuthService {
	
	Result employerRegister(EmployerForRegisterDto employer);
	
    Result jobSeekerRegister(JobSeekerForRegisterDto jobSeeker);
}
