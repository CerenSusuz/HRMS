package com.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.business.abstracts.UserService;
import com.hrms.core.entities.concretes.User;
import com.hrms.core.utilities.results.DataResult;
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
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>
		(this.userDao.findAll(),"Users listed");
	}

	@Override
	public DataResult<User> getByMail(String email) {
		
		User user = null;
        for(User checkUser :this.userDao.findAll()){
            if(user.getEmail()==email){
            	user=checkUser;
            }
        }
        return new SuccessDataResult<User>(user);
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("User add ok");
	}
	


}
