package com.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.business.abstracts.UserService;
import com.hrms.core.entities.concretes.User;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.ErrorDataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.core.utilities.results.SuccessResult;
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
		var result = userDao.getByEmail(email);
		if (result != null) {
			return new SuccessDataResult<User>(result,"User founded");
		}
		return new ErrorDataResult<User>();
	}

	@Override
	public Result add(User user) {
		 var result = this.userDao.save(user);
		 if (result != null) {
			 return new SuccessResult("User Add OK");
		}
		return new SuccessResult("User Add NOT OK");
	}



}
