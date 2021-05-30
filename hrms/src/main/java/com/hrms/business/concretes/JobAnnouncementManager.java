package com.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.business.abstracts.JobAnnouncementService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dataAccess.abstracts.JobAnnouncementDao;
import com.hrms.entities.concretes.JobAnnouncement;

@Service
public class JobAnnouncementManager implements JobAnnouncementService{

	private JobAnnouncementDao jobAnnouncementDao;
	
	@Autowired
	public JobAnnouncementManager(JobAnnouncementDao jobAnnouncementDao) {
		super();
		this.jobAnnouncementDao = jobAnnouncementDao;
	}

	@Override
	public DataResult<List<JobAnnouncement>> getAll() {
		return new SuccessDataResult<List<JobAnnouncement>>
		(this.jobAnnouncementDao.findAll());
	}

	@Override
	public Result add(JobAnnouncement jobAnnouncement) {
		jobAnnouncement.getReleaseDate().equals(LocalDate.now());
		this.jobAnnouncementDao.save(jobAnnouncement);
		return new SuccessResult("Job Announcement added ok");
	}

	@Override
	public DataResult<List<JobAnnouncement>> getByIsActiveTrue() {
		return new SuccessDataResult<List<JobAnnouncement>>
		(this.jobAnnouncementDao.getByIsActiveTrue());
	}

	@Override
	public DataResult<List<JobAnnouncement>> getByApplicationDeadlineLessThanEqual(LocalDate date) {
		return new SuccessDataResult<List<JobAnnouncement>>
		(this.jobAnnouncementDao.getByApplicationDeadlineLessThanEqual(date));
	}

	@Override
	public DataResult<List<JobAnnouncement>> getByIsActiveTrueAndApplicationDeadlineLessThanEqual(LocalDate date) {
		return new SuccessDataResult<List<JobAnnouncement>>
		(this.jobAnnouncementDao.getByIsActiveTrueAndApplicationDeadlineLessThanEqual(date));
	}



}
