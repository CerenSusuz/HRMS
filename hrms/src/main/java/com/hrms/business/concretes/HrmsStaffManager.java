package com.hrms.business.concretes;

import org.springframework.stereotype.Service;

import com.hrms.business.abstracts.HrmsStaffService;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessResult;

@Service
public class HrmsStaffManager implements HrmsStaffService{

	@Override
	public Result confirm() {
		return new SuccessResult("Hrms Confirm OK");
	}

}
