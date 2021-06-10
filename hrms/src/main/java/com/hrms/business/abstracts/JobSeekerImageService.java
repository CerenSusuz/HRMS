package com.hrms.business.abstracts;

import org.springframework.web.multipart.MultipartFile;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.JobSeekerImage;

import java.io.IOException;
import java.util.List;

public interface JobSeekerImageService {
	Result add(MultipartFile file, JobSeekerImage image)throws IOException;
	DataResult<JobSeekerImage> getById(int id)throws IOException;
	DataResult<List<JobSeekerImage>> getByJobSeekerId(int jobSeekerId);
	//delete
	//update
}
