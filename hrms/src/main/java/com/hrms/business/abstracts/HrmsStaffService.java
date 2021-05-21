package com.hrms.business.abstracts;

import java.util.List;

import com.hrms.entities.concretes.HrmsStaff;

public interface HrmsStaffService {
	List<HrmsStaff> getAll();
}
