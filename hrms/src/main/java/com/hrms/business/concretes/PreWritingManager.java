package com.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.business.abstracts.PreWritingService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.ErrorDataResult;
import com.hrms.core.utilities.results.ErrorResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dataAccess.abstracts.PreWritingDao;
import com.hrms.entities.concretes.PreWriting;

@Service
public class PreWritingManager implements PreWritingService{
	
	private PreWritingDao preWritingDao;

	@Autowired
	public PreWritingManager(PreWritingDao preWritingDao) {
		super();
		this.preWritingDao = preWritingDao;
	}
	
	@Override
	public Result add(PreWriting preWritingDao) {
		var result = this.preWritingDao.save(preWritingDao);
		if (result != null) {
			return new SuccessResult("preWritingDao add ok");
		}
		return new ErrorResult("preWritingDao add NOT ok");
	}

	@Override
	public DataResult<List<PreWriting>> getAll() {
		var result =this.preWritingDao.findAll();
		if (result != null) {
			return new SuccessDataResult<List<PreWriting>>(result,"OK");
		}
		return new ErrorDataResult<List<PreWriting>>("NOT OK");
	}

	@Override
	public DataResult<List<PreWriting>> getByJobSeekerId(int jobSeekerId) {
		var result = this.preWritingDao.getByJobSeekerId(jobSeekerId);
		if (result != null) {
			return new SuccessDataResult<List<PreWriting>>(result,"OK");
		}
		return new ErrorDataResult<List<PreWriting>>("NOT OK");
	}
}
