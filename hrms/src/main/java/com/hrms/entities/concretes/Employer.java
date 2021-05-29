package com.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.hrms.core.entities.concretes.User;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@PrimaryKeyJoinColumn(name="user_id",referencedColumnName = "id")
@Data
@Entity
@Table(name = "employers")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)

public class Employer extends User{
	
	@Column(name = "company_name",nullable = false)
	private String companyName;
	
	@Column(name = "web_address",nullable = false)
	private String webAddress;
	
	@Column(name = "phone_number",nullable = false)
	private String phoneNumber;
	

	public Employer(String email,String password, boolean status, String companyName, String webAddress, String phoneNumber) {
		super(email,password,status);
		this.companyName = companyName;
		this.webAddress = webAddress;
		this.phoneNumber = phoneNumber;
	}

	
}


