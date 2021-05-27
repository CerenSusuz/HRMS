package com.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.core.entities.concretes.User;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
	User getByEmail(String email);
}
