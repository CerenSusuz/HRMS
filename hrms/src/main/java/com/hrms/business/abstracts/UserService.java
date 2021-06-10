package com.hrms.business.abstracts;


import com.hrms.core.entities.concretes.User;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;

public interface UserService {
	DataResult<User> getByEmail(String email);
	Result add(User user); 
	//delete
	//update
}
