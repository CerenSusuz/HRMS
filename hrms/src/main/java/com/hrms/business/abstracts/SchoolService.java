package com.hrms.business.abstracts;

import java.util.List;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.School;

public interface SchoolService {
	Result add(School school);
	DataResult<List<School>> getAll();
	DataResult<List<School>> getByJobSeekerIdOrderByGraduationDate(int jobSeeker_id);
}
