package com.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAnnouncements"})

public class Employer extends User{
	
	@Column(name = "company_name",nullable = false)
	@NotBlank
	@NotNull(message="required")
	private String companyName;
	
	@Column(name = "web_address",nullable = false)
	@NotBlank
	@NotNull(message="required")
	private String webAddress;
	
	@Column(name = "phone_number",nullable = false)
	@NotBlank
	@NotNull(message="required")
	@Pattern(regexp ="[0-9\\s]{12}")
	private String phoneNumber;
	
	@OneToMany(mappedBy= "employer")
	@JsonIgnore()
	private List<JobAnnouncement> jobAnnouncements;

	public Employer(String email,String password, boolean status, String companyName, String webAddress, String phoneNumber) {
		super(email,password,status);
		this.companyName = companyName;
		this.webAddress = webAddress;
		this.phoneNumber = phoneNumber;
	}

	
}


