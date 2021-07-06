package com.hrms.business.abstracts;

import java.util.List;

import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.City;

public interface CityService {
	DataResult<List<City>> getAll();
	Result add(City city);
}
