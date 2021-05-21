package com.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.core.entities.concretes.UserOperationClaim;

public interface UserOperationClaimDao extends JpaRepository<UserOperationClaim,Integer>{

}
