package com.hrms.business.abstracts;

import java.util.List;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.Link;

public interface LinkService {
	Result add(Link link);
	//delete
	//update
	DataResult<List<Link>> getAll();
	DataResult<List<Link>> getByJobSeekerId(int jobSeekerId);
}
