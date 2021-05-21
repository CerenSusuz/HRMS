package com.hrms.core.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="user_operation_claim")
public class UserOperationClaim {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="operation_claim_id")
	private int operationClaimId;
	
	@Column(name="user_id")
	private int userId;
	
	public UserOperationClaim() {
		super();
		
	}

	public UserOperationClaim(int id, int operationClaimId, int userId) {
		super();
		this.id = id;
		this.operationClaimId = operationClaimId;
		this.userId = userId;
	}

	
	
}
