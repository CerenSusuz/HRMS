package com.hrms.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.entities.concretes.JobAnnouncement;

public interface JobAnnouncementDao extends JpaRepository<JobAnnouncement, Integer> {
	
	List<JobAnnouncement> getByIsActiveTrue();
	List<JobAnnouncement> getByApplicationDeadlineLessThanEqual(LocalDate date);
	List<JobAnnouncement> getByIsActiveTrueAndApplicationDeadlineLessThanEqual(LocalDate date);
	List<JobAnnouncement> getByIsActiveTrueAndEmployer_CompanyName(String companyName);
	List<JobAnnouncement> getByEmployerId(int id);
	List<JobAnnouncement> getByIsActiveTrueAndCity_Id(int id);
	List<JobAnnouncement> getByIsActiveTrueAndDepartment_Id(int id);
	JobAnnouncement getById(int id);
}
