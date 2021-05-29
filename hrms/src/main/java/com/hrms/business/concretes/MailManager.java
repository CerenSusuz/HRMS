package com.hrms.business.concretes;

import com.hrms.business.abstracts.MailService;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessResult;

public class MailManager implements MailService{

	@Override
	public Result verification(String email) {
		return new SuccessResult("Mail checked");
	}

}
