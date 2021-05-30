package com.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.entities.concretes.JobAnnouncement;

public interface JobAnnouncementDao extends JpaRepository<JobAnnouncement, Integer> {
	List<JobAnnouncement> getByIsActiveTrue();
}
