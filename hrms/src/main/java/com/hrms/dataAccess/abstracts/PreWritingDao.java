package com.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.entities.concretes.PreWriting;

public interface PreWritingDao extends JpaRepository<PreWriting,Integer> {
	List<PreWriting> getByJobSeekerId(int jobSeekerId);
}
