package com.hrms.business.abstracts;

import java.util.List;

import com.hrms.core.entities.concretes.User;

public interface UserService {
	List<User> getAll();
}
