package com.hrms.entities.concretes;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.hrms.core.entities.concretes.User;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@PrimaryKeyJoinColumn(name="user_id",referencedColumnName = "id")
@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name="hrms_staffs")

public class HrmsStaff extends User{
	
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

	public HrmsStaff(String email,String password, boolean status,String firstName, String lastName, String nationalityId) {
		super(email,password,status);
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalityId = nationalityId;
	}
	
	
}
