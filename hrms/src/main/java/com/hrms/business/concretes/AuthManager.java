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
		
		Result result = BusinessRules.run(checkEmployerRegisterForm(employer),
				 checkDomain(employer),
				 checkEmailVerification(employer.getEmail()),
				 checkHrmsConfirm(),
				 checkIfEmailExists(employer.getEmail())
				);
		
		if (result != null) {
			return result;
		}
		
        Employer createEmployer = modelMapper.map(employer,Employer.class)  ;
        this.employerService.add(createEmployer);
        return new SuccessResult("Your registration is completed.");
	}

	@Override
	public Result jobSeekerRegister(JobSeekerForRegisterDto jobSeeker){
		
		Result result = BusinessRules.run(checkJobSeekerRegisterForm(jobSeeker),
				checkMernis(jobSeeker),
				checkIfEmailExists(jobSeeker.getEmail()),
				checkNationalityId(jobSeeker.getNalionalityId()),
				checkPasswordSame(jobSeeker.getPassword(),jobSeeker.getRepassword()),
				checkEmailVerification(jobSeeker.getEmail())				
				);
		if (result != null) {
			return result;
		}
		
	    JobSeeker creteJobSeeker = modelMapper.map(jobSeeker, JobSeeker.class);
        this.jobSeekerService.add(creteJobSeeker);
		return new SuccessResult("Your registration is completed.");
		
	}
	
	// check rules
	
	private Result checkIfEmailExists(String email) {
		Result result = this.userService.findByMail(email);
		if (result != null) {
			return new ErrorResult("e-mail verification could not be performed.");
		}
		return new SuccessResult();
	}
	
	private Result checkEmailVerification(String email) {
		var result = this.mailService.verification(email);
		if (result != null) {
			return new ErrorResult("The user is registered.");
		}
		return new SuccessResult();
	}
	
	private Result checkPasswordSame(String password, String rePassword) {
		if (password != rePassword) {
			return new ErrorResult("Passwords are not the same");
		}
		return new SuccessResult();
	}
	
	
	//for jobSeekers
	
	private Result checkJobSeekerRegisterForm(JobSeekerForRegisterDto jobSeekerForRegisterDto) {
		
		if(jobSeekerForRegisterDto.getFirstName() == null &&
			jobSeekerForRegisterDto.getLastName() == null &&
			jobSeekerForRegisterDto.getNalionalityId() > 0 &&
			jobSeekerForRegisterDto.getYearOfBirth() > 0 &&
			jobSeekerForRegisterDto.getEmail() == null &&
			jobSeekerForRegisterDto.getPassword() == null && 
			jobSeekerForRegisterDto.getRepassword() == null
				){
            return new ErrorResult("Please fill out the form, there is missing information.");
        }
		return new SuccessResult();
	}
	
	private Result checkMernis(JobSeekerForRegisterDto jobSeekerForRegisterDto) {
		 if(!checkPersonService.validate(jobSeekerForRegisterDto.getFirstName(),
				 jobSeekerForRegisterDto.getLastName(),
				 jobSeekerForRegisterDto.getNalionalityId(),
				 jobSeekerForRegisterDto.getYearOfBirth())){
			return new ErrorResult("Identity not verified.");
		}
		return new SuccessResult() ;
	}
	
	private Result checkNationalityId(long nationalityId) {
		Result result = this.jobSeekerService.findByNationalityId(nationalityId);
		if (result != null) {
			return new ErrorResult("The user is registered.");
		}
		return new SuccessResult() ;
	}
			
	//for Employer
	
	private Result checkDomain(EmployerForRegisterDto employerForRegisterDto) {
		String domain = employerForRegisterDto.getEmail().split("@")[1];
        if(domain.equals(employerForRegisterDto.getWebAddress())){
        	return new SuccessResult();
        }
        return new ErrorResult("Company Email mismatch.");
	}
	
	private Result checkEmployerRegisterForm(EmployerForRegisterDto employerForRegisterDto) {
		if(employerForRegisterDto.getCompanyName() == null &&
			employerForRegisterDto.getWebAddress() == null &&
			employerForRegisterDto.getPhoneNumber() == null &&
			employerForRegisterDto.getEmail() == null &&
			employerForRegisterDto.getPassword() == null &&
			employerForRegisterDto.getRepassword() == null
				){
            return new ErrorResult("Please fill out the form, there is missing information.");
        }
		return new SuccessResult();
	}
	
	private Result checkHrmsConfirm() {
		if(this.hrmsService.confirm() == null) {
			return new ErrorResult("Your registration has not been approved by our institution.");
		}
		return new SuccessResult();
	}
	
	
}
	
