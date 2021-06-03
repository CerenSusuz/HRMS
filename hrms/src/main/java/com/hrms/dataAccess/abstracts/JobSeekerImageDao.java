package com.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.entities.concretes.JobSeekerImage;

public interface JobSeekerImageDao extends JpaRepository<JobSeekerImage, Integer> { 
	List<JobSeekerImage> getByJobSeekerId(int jobSeekerId);
	JobSeekerImage getById(int id);
}
