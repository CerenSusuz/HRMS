package com.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerForRegisterDto {
	
	private String companyName;
	private String webAddress;
    private String phoneNumber;
    
	private String email;
	private String password;
	private boolean status;
	
	private String rePassword;
}
