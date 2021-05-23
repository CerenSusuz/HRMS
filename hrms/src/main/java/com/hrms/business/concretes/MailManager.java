package com.hrms.business.concretes;

import com.hrms.business.abstracts.MailService;

public class MailManager implements MailService {

	@Override
	public String send(String mail) {  
		return "Mail Check OK" + mail;
	}

}
