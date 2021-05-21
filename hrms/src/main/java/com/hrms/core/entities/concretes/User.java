package com.hrms.core.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="status")
	private boolean status;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;
	
	public User() {
		super();
	}

	public User(int id, boolean status, String password, String email) {
		super();
		this.id = id;
		this.status = status;
		this.password = password;
		this.email = email;
	}
	
	
	
}
