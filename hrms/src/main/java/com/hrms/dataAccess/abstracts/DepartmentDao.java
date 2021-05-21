package com.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.entities.concretes.Department;

public interface DepartmentDao extends JpaRepository<Department,Integer>{

}