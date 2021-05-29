package com.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerForRegisterDto {
	
	private String firstName;
	private String lastName;
	private long nationalityId;
	private int yearOfBirth;
	
	private String email;
	private String password;
	private boolean status;
	
	private String rePassword;

}
