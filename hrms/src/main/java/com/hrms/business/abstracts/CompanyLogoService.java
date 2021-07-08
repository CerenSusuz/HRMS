package com.hrms.business.abstracts;

import org.springframework.web.multipart.MultipartFile;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.CompanyLogo;

import java.io.IOException;

public interface CompanyLogoService {
	Result add(MultipartFile file, CompanyLogo logo)throws IOException;
	DataResult<CompanyLogo> getById(int id)throws IOException;
	DataResult<CompanyLogo> getByEmployerId(int id);
}
