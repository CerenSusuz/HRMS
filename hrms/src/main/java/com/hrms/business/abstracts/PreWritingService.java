package com.hrms.business.abstracts;

import java.util.List;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.PreWriting;

public interface PreWritingService {
	Result add(PreWriting preWriting);
	//delete
	//update
	DataResult<List<PreWriting>> getAll();
	DataResult<List<PreWriting>> getByJobSeekerId(int jobSeekerId);
}
