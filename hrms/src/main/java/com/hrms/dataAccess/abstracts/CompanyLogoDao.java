package com.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.entities.concretes.CompanyLogo;

@Repository
public interface CompanyLogoDao extends JpaRepository<CompanyLogo, Integer>{
	CompanyLogo getByEmployerUserId(int id);
	CompanyLogo getById(int id);
}
