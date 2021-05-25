package com.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.entities.concretes.HrmsStaff;

@Repository
public interface HrmsStaffDao extends JpaRepository<HrmsStaff, Integer>{

}