package com.hrms.core.adapters.mernis;


public interface UserCheckService {
	 boolean validate(String firstName, String lastName,long nationalityId, int birthYear);
}
