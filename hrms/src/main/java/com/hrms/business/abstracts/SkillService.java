package com.hrms.business.abstracts;

import java.util.List;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.Skill;

public interface SkillService {
	Result add(Skill skill);
	//delete
	//update
	DataResult<List<Skill>> getAll();
	DataResult<List<Skill>> getByJobSeekerId(int jobSeekerId);
}
