package com.hrms.business.abstracts;

import java.util.List;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.SchoolInfo;

public interface SchoolService {
	Result add(SchoolInfo school);
	DataResult<List<SchoolInfo>> getAll();
	DataResult<List<SchoolInfo>> getByJobSeekerIdOrderByGraduationDateASC(int jobSeeker_id);
	DataResult<List<SchoolInfo>> getByJobSeekerIdOrderByGraduationDateDESC(int jobSeeker_id);
}
