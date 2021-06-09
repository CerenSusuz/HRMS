package com.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.business.abstracts.JobExperienceService;
import com.hrms.business.abstracts.JobSeekerImageService;
import com.hrms.business.abstracts.JobSeekerService;
import com.hrms.business.abstracts.LanguageService;
import com.hrms.business.abstracts.LinkService;
import com.hrms.business.abstracts.PreWritingService;
import com.hrms.business.abstracts.SchoolService;
import com.hrms.business.abstracts.SkillService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.ErrorDataResult;
import com.hrms.core.utilities.results.ErrorResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dataAccess.abstracts.JobSeekerDao;
import com.hrms.entities.concretes.JobSeeker;
import com.hrms.entities.dtos.CVDto;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private JobSeekerImageService imageService;
	private LanguageService languageService;
	private LinkService linkService;
	private SkillService skillService;
	private SchoolService schoolService;
	private JobExperienceService experienceService;
	private PreWritingService preWritingService;
	
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, 
			JobSeekerImageService imageService,
			LanguageService languageService,
			LinkService linkService,
			SkillService skillService,
			SchoolService schoolService,
			JobExperienceService experienceService,
			PreWritingService preWritingService
			
		
			) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.imageService = imageService;
		this.languageService = languageService;
		this.linkService = linkService;
		this.skillService = skillService;
		this.schoolService = schoolService;
		this.experienceService = experienceService;
		this.preWritingService = preWritingService;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		var result = this.jobSeekerDao.findAll();
		if (result != null) {
			return new SuccessDataResult<List<JobSeeker>>(result,"Job Seekers listed");	
		}
		return new ErrorDataResult<List<JobSeeker>>("Job Seekers NOT listed");	
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		var result = this.jobSeekerDao.save(jobSeeker);
		if (result != null) {
			return new SuccessResult("Job Seeker Add OK");
		}
		return new ErrorResult("Job Seeker Add NOT OK");
	}

	@Override
	public DataResult<JobSeeker> getByNationalityId(String nationalityId) {
		var result = this.jobSeekerDao.getByNationalityId(nationalityId);
		if (result != null) {
			return new SuccessDataResult<JobSeeker>("User founded");
		}
		return new ErrorDataResult<JobSeeker>("User NOT founded");
	}

	@Override
	public DataResult<CVDto> getCvById(int id) {
		CVDto cv = new CVDto();
		cv.setJobSeeker(this.getById(id).getData());
		cv.setImages(this.imageService.getByJobSeekerId(id).getData());
		cv.setLanguages(this.languageService.getByJobSeekerId(id).getData());
		cv.setLinks(this.linkService.getByJobSeekerId(id).getData());
		cv.setSkills(this.skillService.getByJobSeekerId(id).getData());
		cv.setSchoolInfos(this.schoolService.getByJobSeekerIdOrderByGraduationDateDESC(id).getData());
		cv.setExperiences(this.experienceService.getByJobSeekerIdOrderByDateOfEndDESC(id).getData());
		cv.setPreWritings(this.preWritingService.getByJobSeekerId(id).getData());
		return new SuccessDataResult<>(cv, "get cv ok");
	}

	@Override
	public DataResult<JobSeeker> getById(int id) {
		var result = this.jobSeekerDao.getById(id);
		if (result != null) {
			return new SuccessDataResult<JobSeeker>("User founded");
		}
		return new ErrorDataResult<JobSeeker>("User NOT founded");
	}

}
