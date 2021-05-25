package com.hrms.api;

import java.rmi.RemoteException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.business.abstracts.AuthService;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.dtos.EmployerForRegisterDto;
import com.hrms.entities.dtos.JobSeekerForRegisterDto;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/employerRegister")
    public Result registerForEmployer(@RequestBody EmployerForRegisterDto employerForRegisterDto) {
        return authService.employerRegister(employerForRegisterDto);
    }

    @PostMapping("/jobSeekerRegister")
    public Result registerForJobSeeker(@RequestBody JobSeekerForRegisterDto jobSeekerForRegisterDto) throws RemoteException {
        return authService.jobSeekerRegister(jobSeekerForRegisterDto);
    }

}
