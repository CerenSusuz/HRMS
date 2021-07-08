package com.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.entities.concretes.Link;

@Repository
public interface LinkDao extends JpaRepository<Link, Integer>{
	List<Link> getByJobSeekerId(int jobSeekerId);
}
