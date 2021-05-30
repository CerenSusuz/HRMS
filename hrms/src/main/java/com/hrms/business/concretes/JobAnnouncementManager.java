package com.hrms.business.concretes;

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
		return new SuccessDataResult<List<JobAnnouncement>>(this.jobAnnouncementDao.findAll());
	}

	@Override
	public Result add(JobAnnouncement jobAnnouncement) {
		this.jobAnnouncementDao.save(jobAnnouncement);
		return new SuccessResult("Job Announcement added ok");
	}

}
