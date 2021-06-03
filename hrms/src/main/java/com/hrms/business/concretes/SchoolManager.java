package com.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hrms.business.abstracts.SchoolService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.ErrorDataResult;
import com.hrms.core.utilities.results.ErrorResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dataAccess.abstracts.SchoolDao;
import com.hrms.entities.concretes.SchoolInfo;

@Service
public class SchoolManager implements SchoolService {

	private SchoolDao schoolDao;
	
	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	@Override
	public Result add(SchoolInfo school) {
		var result = this.schoolDao.save(school);
		if (result != null) {
			return new SuccessResult("SchoolInfo add ok");
		}
		return new ErrorResult("SchoolInfo add NOT ok");
	}

	@Override
	public DataResult<List<SchoolInfo>> getAll() {
		var result = this.schoolDao.findAll();
		if (result != null) {
			return new SuccessDataResult<List<SchoolInfo>>(result);
		}
		return new ErrorDataResult<List<SchoolInfo>>();
	}

	@Override
	public DataResult<List<SchoolInfo>> getByJobSeekerIdOrderByGraduationDateASC(int jobSeekerId) {
		Sort sortBy = Sort.by(Sort.Direction.ASC,"graduationDate");
		var result = this.schoolDao.getByJobSeekerId(sortBy,jobSeekerId);
		if (result != null) {
			return new SuccessDataResult<List<SchoolInfo>>(result,"asc sorted ok");
		}
		return new SuccessDataResult<List<SchoolInfo>>("asc sorted NOT ok");
	}

	@Override
	public DataResult<List<SchoolInfo>> getByJobSeekerIdOrderByGraduationDateDESC(int jobSeekerId) {
		Sort sortBy = Sort.by(Sort.Direction.DESC,"graduationDate");
		var result = this.schoolDao.getByJobSeekerId(sortBy,jobSeekerId);
		if (result != null) {
			return new SuccessDataResult<List<SchoolInfo>>(result,"desc sorted ok");
		}
		return new SuccessDataResult<List<SchoolInfo>>("desc sorted NOT ok");
	}

}
