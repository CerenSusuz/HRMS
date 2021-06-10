package com.hrms.entities.concretes;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hrms.core.entities.concretes.User;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@PrimaryKeyJoinColumn(name="user_id",referencedColumnName = "id")
@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "job_seekers")

public class JobSeeker extends User{
	
	@Column(name="first_name",nullable = false)
	@NotBlank
	@NotNull(message="required")
	private String firstName;
	
	@Column(name="last_name",nullable = false)
	@NotBlank
	@NotNull(message="required")
	private String lastName;
	
	@Column(name="nationality_id",nullable = false)
	@NotBlank
	@NotNull(message="required")
	private String nationalityId;
	
	@Column(name="year_of_birth",nullable = false)
	@NotBlank
	@NotNull(message="required")
	private int yearOfBirth;
	
	@OneToMany(mappedBy = "jobSeeker")
	@JsonIgnore()
	private List<SchoolInfo> schoolInfos;
	
	@OneToMany(mappedBy = "jobSeeker")
	@JsonIgnore()
	private List<JobExperience> jobExperiences;
	
	@OneToMany(mappedBy = "jobSeeker")
	@JsonIgnore()
	private List<Language> languages;
	
	@OneToMany(mappedBy = "jobSeeker")
	@JsonIgnore()
	private List<Link> links;
	
	@OneToMany(mappedBy = "jobSeeker")
	@JsonIgnore()
	private List<Skill> skills;

	@OneToMany(mappedBy = "jobSeeker")
	@JsonIgnore()
	private List<PreWriting> preWritings;
	
	
	public JobSeeker(String email, String password, boolean status, String firstName, String lastName, String nationalityId, int yearOfBirth) {
		super(email, password, status);
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalityId = nationalityId;
		this.yearOfBirth = yearOfBirth;
	}
	

}

