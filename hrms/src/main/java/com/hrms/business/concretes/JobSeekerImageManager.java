package com.hrms.business.concretes;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hrms.business.abstracts.JobSeekerImageService;
import com.hrms.core.utilities.helpers.abstracts.FileHelper;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.ErrorDataResult;
import com.hrms.core.utilities.results.ErrorResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dataAccess.abstracts.JobSeekerImageDao;
import com.hrms.entities.concretes.JobSeekerImage;

@Service
public class JobSeekerImageManager implements JobSeekerImageService {

	private JobSeekerImageDao jobSeekerImageDao;
	private FileHelper helper;
	
	@Autowired
	public JobSeekerImageManager(JobSeekerImageDao jobSeekerImageDao,FileHelper helper) {
		super();
		this.jobSeekerImageDao = jobSeekerImageDao;
		this.helper = helper;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Result add(MultipartFile file, JobSeekerImage image) throws IOException {
		Map<String,String> getImage = (Map<String,String>)helper.upload(file).getData();
		image.setPath(getImage.get("url"));
		image.setUploadedAt(LocalDate.now());
		var result = this.jobSeekerImageDao.save(image);
		if(result != null) {
			return new SuccessResult("image upload ok");
		}
		return new ErrorResult("image upload NOT ok");
	}

	@Override
	public DataResult<JobSeekerImage> getById(int id) {
		var result =  this.jobSeekerImageDao.getById(id);
		if(result != null) {
			return new SuccessDataResult<JobSeekerImage>(result);
		}
		return new ErrorDataResult<JobSeekerImage>("image NOT founded");
	}

	@Override
	public DataResult<List<JobSeekerImage>> getByJobSeekerId(int jobSeekerId) {
		var result =  this.jobSeekerImageDao.getByJobSeekerId(jobSeekerId);
		if (result != null) {
			return new SuccessDataResult<List<JobSeekerImage>>(this.jobSeekerImageDao.getByJobSeekerId(jobSeekerId));
		}
		return new ErrorDataResult<List<JobSeekerImage>>("image not founded");
	}

}
