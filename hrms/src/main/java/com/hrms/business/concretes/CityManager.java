package com.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrms.business.abstracts.CityService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dataAccess.abstracts.CityDao;
import com.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService{
	
	private CityDao cityDao;

	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>
		(this.cityDao.findAll());
	}

	@Override
	public Result add(City city) {
		this.cityDao.save(city);
		return new SuccessResult("City added ok");
	}
	
	
}
