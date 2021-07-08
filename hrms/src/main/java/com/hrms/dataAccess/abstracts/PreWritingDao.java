package com.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.entities.concretes.PreWriting;

@Repository
public interface PreWritingDao extends JpaRepository<PreWriting,Integer> {
	List<PreWriting> getByJobSeekerId(int jobSeekerId);
}
