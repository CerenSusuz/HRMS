package com.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.entities.concretes.JobExperience;

@Repository
public interface JobExperienceDao extends JpaRepository<JobExperience,Integer>{
	List<JobExperience> getByJobSeekerId(Sort sort, int jobSeeker_id);
}
