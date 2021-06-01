package com.hrms.core.entities.concretes;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "email")
	@Email
	@NotBlank
	@NotNull(message="required")
	private String email;
	
	@Column(name = "password")
	@NotBlank
	@NotNull(message="required")
	@Size(min=6)
	private String password;
	
	@Column(name = "status")
	private boolean status;
	
	public User(String email, String password, boolean status) {
		this.email = email;
		this.password = password;
		this.status = status;
	}
}
