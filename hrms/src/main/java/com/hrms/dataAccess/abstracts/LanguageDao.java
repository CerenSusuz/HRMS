package com.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language, Integer>{
	 List<Language> getByJobSeekerId(int jobSeekerId);
}
