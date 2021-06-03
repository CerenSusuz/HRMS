package com.hrms.core.utilities.helpers;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import com.hrms.core.utilities.helpers.abstracts.FileHelper;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.core.utilities.results.SuccessResult;

public class CloudinaryManager implements FileHelper {
	
	private Cloudinary cloudinary;
	
	@Autowired
	public CloudinaryManager(Cloudinary cloudinary) {
		super();
		this.cloudinary = cloudinary;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public DataResult<?> upload(MultipartFile file) throws IOException {
		Map result = cloudinary.uploader().upload(file.getBytes(),ObjectUtils.emptyMap());
		return new SuccessDataResult<Map>(result);
		 
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Result delete(String id) throws IOException {
		Map result = cloudinary.uploader().destroy(id,ObjectUtils.emptyMap());
		return new SuccessResult(result.toString());
	}

}
