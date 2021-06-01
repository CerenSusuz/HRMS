package com.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hrms.business.abstracts.SchoolService;
import com.hrms.core.utilities.results.DataResult;
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
		this.schoolDao.save(school);
		return new SuccessResult("SchoolInfo add ok");
	}

	@Override
	public DataResult<List<SchoolInfo>> getAll() {
		return new SuccessDataResult<List<SchoolInfo>>
		(this.schoolDao.findAll());
	}

	@Override
	public DataResult<List<SchoolInfo>> getByJobSeekerIdOrderByGraduationDateASC(int jobSeeker_id) {
		Sort sortBy = Sort.by(Sort.Direction.ASC,"graduationDate");
		return new SuccessDataResult<List<SchoolInfo>>
		(this.schoolDao.getByJobSeekerId(sortBy,jobSeeker_id),"asc sorted ok");
	}

	@Override
	public DataResult<List<SchoolInfo>> getByJobSeekerIdOrderByGraduationDateDESC(int jobSeeker_id) {
		Sort sortBy = Sort.by(Sort.Direction.DESC,"graduationDate");
		return new SuccessDataResult<List<SchoolInfo>>
		(this.schoolDao.getByJobSeekerId(sortBy,jobSeeker_id),"desc sorted ok");
	}

}
