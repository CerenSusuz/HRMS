package com.hrms.entities.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerForRegisterDto {
	
	@NotBlank
	private String companyName;
	
	@NotBlank
	private String webAddress;
	
	@NotBlank(message="required")
	@Pattern(regexp ="[0-9\\s]{12}")
    private String phoneNumber;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String password;
	
	private boolean status;
	@NotBlank
	private String rePassword;
}
