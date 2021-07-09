package com.hrms.business.concretes;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hrms.business.abstracts.CompanyLogoService;
import com.hrms.core.utilities.helpers.abstracts.FileHelper;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.ErrorDataResult;
import com.hrms.core.utilities.results.ErrorResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dataAccess.abstracts.CompanyLogoDao;
import com.hrms.entities.concretes.CompanyLogo;

@Service
public class CompanyLogoManager implements CompanyLogoService{

	private CompanyLogoDao logoDao;
	private FileHelper helper;
	
	@Autowired
	public CompanyLogoManager(CompanyLogoDao logoDao, FileHelper helper) {
		super();
		this.logoDao = logoDao;
		this.helper = helper;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Result add(MultipartFile file, CompanyLogo logo) throws IOException {
		Map<String,String> getImage = (Map<String,String>)helper.upload(file).getData();
		logo.setPath(getImage.get("url"));
		logo.setUploadedAt(LocalDate.now());
		var result = this.logoDao.save(logo);
		if(result != null) {
			return new SuccessResult("logo upload ok");
		}
		return new ErrorResult("logo upload NOT ok");
	}

	@Override
	public DataResult<CompanyLogo> getById(int id) throws IOException {
		var result =  this.logoDao.getById(id);
		if(result != null) {
			return new SuccessDataResult<CompanyLogo>(result);
		}
		return new ErrorDataResult<CompanyLogo>("logo NOT founded");
	}

	@Override
	public DataResult<CompanyLogo> getByEmployerId(int id) {
		var result =  this.logoDao.getByEmployerUserId(id);
		if (result != null) {
			return new SuccessDataResult<CompanyLogo>(this.logoDao.getByEmployerUserId(id));
		}
		return new ErrorDataResult<CompanyLogo>("logo not founded");
	}

}
