package com.hrms.business.abstracts;

import java.util.List;

import com.hrms.core.entities.concretes.User;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;

public interface UserService {
	DataResult<List<User>> getAll();
	DataResult<User> getByMail(String email);
	Result add(User user);
}
