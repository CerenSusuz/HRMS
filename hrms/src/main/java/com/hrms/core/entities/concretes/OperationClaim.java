package com.hrms.core.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="operation_claim")
public class OperationClaim {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	public OperationClaim() {
		super();
	}
	
	public OperationClaim(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}