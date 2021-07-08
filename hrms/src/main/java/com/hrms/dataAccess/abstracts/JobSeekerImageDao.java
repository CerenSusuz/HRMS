package com.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.entities.concretes.JobSeekerImage;

@Repository
public interface JobSeekerImageDao extends JpaRepository<JobSeekerImage, Integer> { 
	List<JobSeekerImage> getByJobSeekerId(int jobSeekerId);
	JobSeekerImage getById(int id);
}
