package com.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.entities.concretes.HrmsStaff;

public interface HrmsStaffDao extends JpaRepository<HrmsStaff, Integer>{

}