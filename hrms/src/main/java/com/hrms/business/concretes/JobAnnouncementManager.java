package com.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.business.abstracts.JobAnnouncementService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.ErrorDataResult;
import com.hrms.core.utilities.results.ErrorResult;
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
		var result = this.jobAnnouncementDao.findAll();
		if (result != null) {
			return new SuccessDataResult<List<JobAnnouncement>>(result);
		}
		return new ErrorDataResult<List<JobAnnouncement>>();
	}

	@Override
	public Result add(JobAnnouncement jobAnnouncement) {
		jobAnnouncement.setReleaseDate(LocalDate.now());
		jobAnnouncement.setActive(false);
		 var result = this.jobAnnouncementDao.save(jobAnnouncement);
		 if (result != null) {
			 return new SuccessResult("Job Announcement added ok");
		}
		return new ErrorResult("Job Announcement added NOT ok");
	}

	@Override
	public DataResult<List<JobAnnouncement>> getByIsActiveTrue() {
		var result = this.jobAnnouncementDao.getByIsActiveTrue();
		if (result != null) {
			return new SuccessDataResult<List<JobAnnouncement>>(result,"Active Job announcements get ok");
		}
		return new SuccessDataResult<List<JobAnnouncement>>("Active Job announcements get NOT ok");
		}

	@Override
	public DataResult<List<JobAnnouncement>> getByApplicationDeadlineLessThanEqual(LocalDate date) {
		var result = this.jobAnnouncementDao.getByApplicationDeadlineLessThanEqual(date);
		if (result !=  null) {
			return new SuccessDataResult<List<JobAnnouncement>>(result);
		}
		return new ErrorDataResult<List<JobAnnouncement>>();
	}

	@Override
	public DataResult<List<JobAnnouncement>> getByIsActiveTrueAndApplicationDeadlineLessThanEqual(LocalDate date) {
		var result = this.jobAnnouncementDao.getByIsActiveTrueAndApplicationDeadlineLessThanEqual(date);
		if (result != null) {
			return new SuccessDataResult<List<JobAnnouncement>>(result,"OK");
		}
		return new ErrorDataResult<List<JobAnnouncement>>("NOT OK");
	}

	@Override
	public DataResult<List<JobAnnouncement>> getByIsActiveTrueAndEmployer_CompanyName(String companyName) {
		var result = this.jobAnnouncementDao.getByIsActiveTrueAndEmployer_CompanyName(companyName);
		if (result != null) {
			return new SuccessDataResult<List<JobAnnouncement>>(result,"OK");
		}
		return new ErrorDataResult<List<JobAnnouncement>>("NOT OK");
	}

	@Override
	public DataResult<List<JobAnnouncement>> getByEmployerId(int id) {
		var result = this.jobAnnouncementDao.getByEmployerUserId(id);
		if (result != null) {
			return new SuccessDataResult<List<JobAnnouncement>>(result,"Ok");
		}
		return new ErrorDataResult<List<JobAnnouncement>>("Not ok");
	}

	@Override
	public DataResult<JobAnnouncement> changeStatus(int employerId,int announcementId, boolean status) {
		
		List<JobAnnouncement> announcements = this.jobAnnouncementDao.getByEmployerUserId(employerId);
		
		for (JobAnnouncement jobAnnouncement : announcements) {
			if (announcementId == jobAnnouncement.getId()) {
				jobAnnouncement.setActive(status);
				this.jobAnnouncementDao.save(jobAnnouncement);
				return new SuccessDataResult<JobAnnouncement>(this.jobAnnouncementDao.getById(announcementId));
			}
		}
		
		return new ErrorDataResult<JobAnnouncement>();	
	}

	@Override
	public DataResult<JobAnnouncement> getById(int id) {
		var result = this.jobAnnouncementDao.getById(id);
		if (result != null) {
			return new SuccessDataResult<JobAnnouncement>(result,"JobAnnouncement founded");
		}
		return new ErrorDataResult<JobAnnouncement>("JobAnnouncement NOT founded");
	}

	@Override
	public DataResult<List<JobAnnouncement>> getByIsActiveTrueAndCity_Id(int id) {
		var result = this.jobAnnouncementDao.getByIsActiveTrueAndCity_Id(id);
		if (result != null) {
			return new SuccessDataResult<List<JobAnnouncement>>(result,"OK");
		}
		return new ErrorDataResult<List<JobAnnouncement>>("Not ok");
	}

	@Override
	public DataResult<List<JobAnnouncement>> getByIsActiveTrueAndDepartment_Id(int id) {
		var result = this.jobAnnouncementDao.getByIsActiveTrueAndDepartment_Id(id);
		if (result != null) {
			return new SuccessDataResult<List<JobAnnouncement>>(result,"OK");
		}
		return new ErrorDataResult<List<JobAnnouncement>>("Not ok");
	}


}
