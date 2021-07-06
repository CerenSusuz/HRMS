package com.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.business.abstracts.CityService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.ErrorDataResult;
import com.hrms.core.utilities.results.ErrorResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dataAccess.abstracts.CityDao;
import com.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService{
	
	private CityDao cityDao;

	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {
		var result = this.cityDao.findAll();
		if (result != null) {
			return new SuccessDataResult<List<City>>(result,"OK");
		}
		return new ErrorDataResult<List<City>>("Not ok");
	}

	@Override
	public Result add(City city) {
		var result = this.cityDao.save(city);
		if (result != null) {
			return new SuccessResult("City added ok");
		}
		return new ErrorResult("City added NOT ok");
	}

	
}
