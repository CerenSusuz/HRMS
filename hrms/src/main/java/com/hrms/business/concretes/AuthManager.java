package com.hrms.business.concretes;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.business.abstracts.AuthService;
import com.hrms.business.abstracts.EmployerService;
import com.hrms.business.abstracts.HrmsStaffService;
import com.hrms.business.abstracts.JobSeekerService;
import com.hrms.business.abstracts.MailService;
import com.hrms.business.abstracts.UserService;
import com.hrms.core.adapters.mernis.UserCheckService;
import com.hrms.core.utilities.business.BusinessRules;
import com.hrms.core.utilities.results.ErrorResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.entities.concretes.Employer;
import com.hrms.entities.concretes.JobSeeker;
import com.hrms.entities.dtos.EmployerForRegisterDto;
import com.hrms.entities.dtos.JobSeekerForRegisterDto;

@Service
public class AuthManager implements AuthService{

	private UserService userService;
	private JobSeekerService jobSeekerService;
	private MailService mailService;
	private EmployerService employerService;
	private UserCheckService checkPersonService;
	private ModelMapper modelMapper;
	private HrmsStaffService hrmsService;
	
	@Autowired
	public AuthManager(UserService userService, 
			JobSeekerService jobSeekerService,
			MailService mailService,
			EmployerService employerService,
			UserCheckService checkPersonService,
			ModelMapper modelMapper,
			HrmsStaffService hrmsService) {
		super();
		this.userService = userService;
		this.jobSeekerService = jobSeekerService;
		this.mailService = mailService;
		this.employerService = employerService;
		this.checkPersonService = checkPersonService;
		this.modelMapper = modelMapper;
		this.hrmsService = hrmsService;
		
	}

	@Override
	public Result employerRegister(EmployerForRegisterDto employer) {
		
		var result = BusinessRules.run(
				 checkDomain(employer),
				 checkEmailVerification(employer.getEmail()),
				 checkIfEmailExists(employer.getEmail()),
				 checkPasswordSame(employer.getPassword(),employer.getRePassword())
				);
		if (result != null) {
			return result;
		}
		
        Employer createEmployer = modelMapper.map(employer,Employer.class);
        createEmployer.setStatus(false);      
        this.employerService.add(createEmployer);
        return new SuccessResult("Your registration is completed.");
	}

	@Override
	public Result jobSeekerRegister(JobSeekerForRegisterDto jobSeeker){
		Result result = BusinessRules.run(
				checkMernis(jobSeeker),
				checkIfEmailExists(jobSeeker.getEmail()),
				checkNationalityId(jobSeeker.getNationalityId()),
				checkPasswordSame(jobSeeker.getPassword(),jobSeeker.getRePassword()),
				checkEmailVerification(jobSeeker.getEmail())				
				);
		
		if (result != null) {
			return result;
		}
		
		JobSeeker creteJobSeeker = modelMapper.map(jobSeeker, JobSeeker.class);
		creteJobSeeker.setStatus(false);
        this.jobSeekerService.add(creteJobSeeker);
		return new SuccessResult("Your registration is completed.");
		
	}
	
	// check rules
	
	private Result checkIfEmailExists(String email) {
		
		Result result = this.userService.getByEmail(email);
		
		if (result.getMessage() != null) {
			return new ErrorResult("e-mail already registered");
		}
		return new SuccessResult();
	}
	
	private Result checkEmailVerification(String email) {
		
		Result result = this.mailService.verification(email);
		
		if (result == null) {
			return new ErrorResult("email could not be verified");
		}
		
		return new SuccessResult();
	}
	
	private Result checkPasswordSame(String password, String rePassword) {
		
		if (!password.equals(rePassword)) {
			return new ErrorResult("Passwords are not the same");
		}
		
		return new SuccessResult();
	}
	
	
	//for jobSeekers
		
	private Result checkMernis(JobSeekerForRegisterDto jobSeeker) {
		 
		if(checkPersonService.validate(
				jobSeeker.getNationalityId(),
				jobSeeker.getYearOfBirth())== false) {
			return new ErrorResult("Identity not verified.");
		}
		return new SuccessResult() ;
	}
	
	private Result checkNationalityId(String nationalityId) {
		
		Result result = this.jobSeekerService.getByNationalityId(nationalityId);
		
		if (result.getMessage() != null) {
			return new ErrorResult("User already registered.");
		}
		return new SuccessResult() ;
	}
			
	//for Employer
	
	private Result checkDomain(EmployerForRegisterDto employerForRegisterDto) {
		
		String domain = employerForRegisterDto.getEmail().split("@")[0];
		
		if(domain.equals(employerForRegisterDto.getWebAddress())){
        	return new SuccessResult();
        }
		
        return new ErrorResult("Company Email mismatch.");
	}
	
}
	
