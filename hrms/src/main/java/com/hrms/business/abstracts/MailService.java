package com.hrms.business.abstracts;

import com.hrms.core.utilities.results.Result;

public interface MailService {
	Result verification(String email);
}
