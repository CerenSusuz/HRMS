package com.hrms.core.adapters.mernis;

import org.springframework.stereotype.Service;


@Service
public class MernisServiceAdapter implements UserCheckService {

	@Override
	public boolean validate(String nationalityId, int birthYear) {
		if (nationalityId.length() == 11 && birthYear > 1900) {
			return true;
		}
		else {
			return false;
		}
	}


}