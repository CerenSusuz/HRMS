package com.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.hrms.core.entities.concretes.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name="employers")
public class Employer extends User{
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="web_address")
	private String webAddress;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@OneToOne
	   @JoinColumn(name = "user_id")
	private int userId;

	public Employer(int id, boolean status, String password, String email) {
		super(id, status, password, email);
	}

	public Employer(int id, String companyName, String webAddress, String phoneNumber, int userId) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.webAddress = webAddress;
		this.phoneNumber = phoneNumber;
		this.userId = userId;
	}
	
	
	

}


