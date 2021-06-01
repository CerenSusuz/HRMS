package com.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.entities.concretes.School;

@Repository
public interface SchoolDao extends JpaRepository<School, Integer> {
	List<School> getByJobSeekerIdOrderByGraduationDate(int jobSeeker_id);
}
