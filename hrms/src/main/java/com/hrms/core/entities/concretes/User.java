package com.hrms.core.entities.concretes;

import javax.persistence.*;

import com.hrms.entities.concretes.Employer;
import com.hrms.entities.concretes.HrmsStaff;
import com.hrms.entities.concretes.JobSeeker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	
	@Column(name="status")
	boolean status;
	
	@Column(name="password")
	String password;
	
	@Column(name="email")
	String email;
	
	@OneToOne(mappedBy = "user")
	private JobSeeker jobSeeker;
	
	@OneToOne(mappedBy = "user")
	private Employer employer;
	
	@OneToOne(mappedBy = "user")
	private HrmsStaff hrmsStaff;
	
}
