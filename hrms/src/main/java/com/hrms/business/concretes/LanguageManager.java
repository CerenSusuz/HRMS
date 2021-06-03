package com.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.business.abstracts.LanguageService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.ErrorDataResult;
import com.hrms.core.utilities.results.ErrorResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dataAccess.abstracts.LanguageDao;
import com.hrms.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService{

	private LanguageDao languageDao;

	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}

	@Override
	public Result add(Language language) {
		var result = this.languageDao.save(language);
		if (result != null) {
			return new SuccessResult("language add ok");
		}
		return new ErrorResult("language add NOT ok");
	}

	@Override
	public DataResult<List<Language>> getAll() {
		var result =this.languageDao.findAll();
		if (result != null) {
			return new SuccessDataResult<List<Language>>(result,"OK");
		}
		return new ErrorDataResult<List<Language>>("NOT OK");
	}

	@Override
	public DataResult<List<Language>> getByJobSeekerId(int jobSeekerId) {
		var result = this.languageDao.getByJobSeekerId(jobSeekerId);
		if (result != null) {
			return new SuccessDataResult<List<Language>>(result,"OK");
		}
		return new ErrorDataResult<List<Language>>("NOT OK");
	}
	
	
}
