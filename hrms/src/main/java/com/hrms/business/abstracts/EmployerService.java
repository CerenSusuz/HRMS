package com.hrms.business.abstracts;

import java.util.List;

import com.hrms.entities.concretes.Employer;

public interface EmployerService {
	List<Employer> getAll();
}
