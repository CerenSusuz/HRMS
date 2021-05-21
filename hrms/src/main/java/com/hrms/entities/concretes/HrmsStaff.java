package com.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hrms.core.entities.concretes.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name="hrms_staffs")
public class HrmsStaff extends User {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="nalionality_id")
	private String nalionalityId;
	
	@Column(name="user_id")
	private int userId;
	
	public HrmsStaff() {
		super();
	}

	public HrmsStaff(int id, String firstName, String lastName, String nalionalityId, int userId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nalionalityId = nalionalityId;
		this.userId = userId;
	}

	
}
