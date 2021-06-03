package com.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.business.abstracts.SkillService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.ErrorDataResult;
import com.hrms.core.utilities.results.ErrorResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dataAccess.abstracts.SkillDao;
import com.hrms.entities.concretes.Skill;

@Service
public class SkillManager implements SkillService{

	private SkillDao skillDao;

	@Autowired
	public SkillManager(SkillDao skillDao) {
		super();
		this.skillDao = skillDao;
	}
	
	@Override
	public Result add(Skill skill) {
		var result = this.skillDao.save(skill);
		if (result != null) {
			return new SuccessResult("skill add ok");
		}
		return new ErrorResult("skill add NOT ok");
	}

	@Override
	public DataResult<List<Skill>> getAll() {
		var result =this.skillDao.findAll();
		if (result != null) {
			return new SuccessDataResult<List<Skill>>(result,"OK");
		}
		return new ErrorDataResult<List<Skill>>("NOT OK");
	}

	@Override
	public DataResult<List<Skill>> getByJobSeekerId(int jobSeekerId) {
		var result = this.skillDao.getByJobSeekerId(jobSeekerId);
		if (result != null) {
			return new SuccessDataResult<List<Skill>>(result,"OK");
		}
		return new ErrorDataResult<List<Skill>>("NOT OK");
	}

}
