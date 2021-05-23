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
import com.hrms.core.adapters.checkPerson.CheckPersonService;
import com.hrms.core.adapters.checkPerson.Person;
import com.hrms.core.utilities.results.ErrorResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.entities.concretes.Employer;
import com.hrms.entities.concretes.JobSeeker;
import com.hrms.entities.dtos.EmployerForRegisterDto;
import com.hrms.entities.dtos.JobSeekerForRegisterDto;
import com.hrms.entities.dtos.UserForLoginDto;


@Service
public class AuthManager implements AuthService{

	private UserService userService;
	private JobSeekerService jobSeekerService;
	private EmployerService employerService;
	private CheckPersonService checkPersonService;
	private ModelMapper modelMapper;
	private MailService mailService;
	private HrmsStaffService hrmsService;
	
	@Autowired
	public AuthManager(UserService userService, 
			JobSeekerService jobSeekerService,
			EmployerService employerService,
			CheckPersonService checkPersonService,
			ModelMapper modelMapper,
			MailService mailService,
			HrmsStaffService hrmsService) {
		super();
		this.userService = userService;
		this.jobSeekerService = jobSeekerService;
		this.employerService = employerService;
		this.checkPersonService = checkPersonService;
		this.modelMapper = modelMapper;
		this.mailService = mailService;
		this.hrmsService = hrmsService;
		
	}

	@Override
	public Result login(UserForLoginDto userForLoginDto) {
		var userToCheck = checkEmail(userForLoginDto.getEmail());
		if (userToCheck != null) {
			return new ErrorResult("The user not found.");
		}
		return new SuccessResult() ; 
	}

	@Override
	public Result employerRegister(EmployerForRegisterDto employerForRegisterDto) {
		
		if(checkEmployerRegisterForm(employerForRegisterDto) != null &&
			checkPasswordSame(employerForRegisterDto.getPassword(), employerForRegisterDto.getRepassword()) != null &&
			checkMailVerification(employerForRegisterDto.getEmail()) != null &&
			checkDomain(employerForRegisterDto) != null &&
			checkHrmsConfirm() != null &&
			checkEmail(employerForRegisterDto.getEmail()) != null ) {
			return new ErrorResult("Your registration is NOT completed.");
		}
		
        Employer employer = modelMapper.map(employerForRegisterDto,Employer.class)  ;
        this.employerService.add(employer);
        return new SuccessResult("Your registration is completed.");
	}

	@Override
	public Result jobSeekerRegister(JobSeekerForRegisterDto jobSeekerForRegisterDto) {
		
	    if(checkJobSeekerRegisterForm(jobSeekerForRegisterDto) != null &&
	        checkMernis(jobSeekerForRegisterDto) != null &&
	    	checkEmail(jobSeekerForRegisterDto.getEmail()) != null &&
	    	checkNationalityId(jobSeekerForRegisterDto.getNalionalityId()) != null &&
	    	checkPasswordSame(jobSeekerForRegisterDto.getPassword(), jobSeekerForRegisterDto.getRepassword()) != null &&
	    	checkMailVerification(jobSeekerForRegisterDto.getEmail()) != null) {
	    	return new ErrorResult("Your registration is NOT completed.");
	    }
	
	    JobSeeker jobSeeker = modelMapper.map(jobSeekerForRegisterDto, JobSeeker.class);
        this.jobSeekerService.add(jobSeeker);
		return new SuccessResult("Your registration is completed.");
		
	}
	
	// check rules
	
	private Result checkPasswordSame(String password, String rePassword) {
		if (password != rePassword) {
			return new ErrorResult("Passwords are not the same");
		}
		return new SuccessResult();
	}
	
	private Result checkMailVerification(String email) {
		this.mailService.send(email);
		return new SuccessResult("OK");
	}
	
	private Result checkEmail(String email) {
		if(this.userService.getByMail(email) != null){
			 return new ErrorResult("The user is registered.");
		}
		return new SuccessResult() ;
	}
	
	//for jobSeekers
	
	private Result checkJobSeekerRegisterForm(JobSeekerForRegisterDto jobSeekerForRegisterDto) {
		
		if(jobSeekerForRegisterDto.getFirstName() == null &&
			jobSeekerForRegisterDto.getLastName() == null &&
			jobSeekerForRegisterDto.getNalionalityId() == null &&
			jobSeekerForRegisterDto.getYearOfBirth() == null &&
			jobSeekerForRegisterDto.getEmail() == null &&
			jobSeekerForRegisterDto.getPassword() == null && 
			jobSeekerForRegisterDto.getRepassword() == null
				){
            return new ErrorResult("Please fill out the form, there is missing information.");
        }
		return new SuccessResult();
	}
	
	private Result checkMernis(JobSeekerForRegisterDto jobSeekerForRegisterDto) {
		 if(!checkPersonService.validate(modelMapper.map(jobSeekerForRegisterDto, Person.class))){
			return new ErrorResult("Identity not verified.");
		}
		return new SuccessResult() ;
	}
	
	private Result checkNationalityId(String nationalityId) {
		if (this.jobSeekerService.getByNationalityId(nationalityId) != null) {
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
	
