package com.hrms.business.abstracts;

import java.util.List;

import com.hrms.entities.concretes.Department;

public interface DepartmentService {
	List<Department> getAll();
}
