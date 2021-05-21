package com.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.core.entities.concretes.OperationClaim;

public interface OperationClaimDao extends JpaRepository<OperationClaim,Integer>{

}
