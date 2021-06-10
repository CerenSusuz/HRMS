package com.hrms.business.abstracts;

import java.util.List;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.SchoolInfo;

public interface SchoolService {
	Result add(SchoolInfo school);
	//delete
	//update
	DataResult<List<SchoolInfo>> getAll();
	DataResult<List<SchoolInfo>> getByJobSeekerIdOrderByGraduationDateASC(int jobSeekerId);
	DataResult<List<SchoolInfo>> getByJobSeekerIdOrderByGraduationDateDESC(int jobSeekerId);
}
