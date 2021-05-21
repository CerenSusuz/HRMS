package com.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer,Integer> {

}