package com.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.business.abstracts.UserService;
import com.hrms.core.entities.concretes.User;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.dataAccess.abstracts.UserDao;

@Service
public class UserManager implements UserService {

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<User> getByEmail(String email) {
		return new SuccessDataResult<User>(userDao.getByEmail(email));
	}



}
