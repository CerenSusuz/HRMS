package com.hrms.business.abstracts;


import com.hrms.core.entities.concretes.User;
import com.hrms.core.utilities.results.DataResult;

public interface UserService {
	DataResult<User> getByEmail(String email);
}
