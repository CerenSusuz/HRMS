package com.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.business.abstracts.SchoolService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dataAccess.abstracts.SchoolDao;
import com.hrms.entities.concretes.City;
import com.hrms.entities.concretes.School;

@Service
public class SchoolManager implements SchoolService {

	private SchoolDao schoolDao;
	
	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	@Override
	public Result add(School school) {
		this.schoolDao.save(school);
		return new SuccessResult("School add ok");
	}

	@Override
	public DataResult<List<School>> getAll() {
		return new SuccessDataResult<List<School>>
		(this.schoolDao.findAll());
	}

	@Override
	public DataResult<List<School>> getByJobSeekerIdOrderByGraduationDate(int jobSeeker_id) {
		return new SuccessDataResult<List<School>>
		(this.schoolDao.getByJobSeekerIdOrderByGraduationDate(jobSeeker_id));
	}

}
