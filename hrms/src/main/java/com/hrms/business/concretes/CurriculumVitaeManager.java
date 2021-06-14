package com.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.business.abstracts.CurriculumVitaeService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.ErrorDataResult;
import com.hrms.core.utilities.results.ErrorResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import com.hrms.entities.concretes.CurriculumVitae;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService{

	private CurriculumVitaeDao curriculumVitaeDao;

	@Autowired
	public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao) {
		super();
		this.curriculumVitaeDao = curriculumVitaeDao;
	}
	
	@Override
	public Result add(CurriculumVitae curriculumVitae) {
		var result = this.curriculumVitaeDao.save(curriculumVitae);
		if (result != null) {
			return new SuccessResult("curriculumVitae added ok");
		}
		return new ErrorResult("curriculumVitae added NOT ok");
	}

	@Override
	public DataResult<List<CurriculumVitae>> getAll() {
		var result = this.curriculumVitaeDao.findAll();
		if (result != null) {
			return new SuccessDataResult<List<CurriculumVitae>>(result,"OK");
		}
		return new ErrorDataResult<List<CurriculumVitae>>("Not ok");
	}

}
