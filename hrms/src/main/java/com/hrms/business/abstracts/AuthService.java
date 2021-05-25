package com.hrms.business.abstracts;

import java.rmi.RemoteException;

import com.hrms.core.utilities.results.Result;
import com.hrms.entities.dtos.EmployerForRegisterDto;
import com.hrms.entities.dtos.JobSeekerForRegisterDto;
import com.hrms.entities.dtos.UserForLoginDto;

public interface AuthService {
	Result login(UserForLoginDto userForLoginDto);
	Result employerRegister(EmployerForRegisterDto employerForRegisterDto);
    Result jobSeekerRegister(JobSeekerForRegisterDto jobSeekerForRegisterDto) throws RemoteException;
}
