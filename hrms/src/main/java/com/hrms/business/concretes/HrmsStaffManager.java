package com.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.business.abstracts.HrmsStaffService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.dataAccess.abstracts.HrmsStaffDao;
import com.hrms.entities.concretes.HrmsStaff;

@Service
public class HrmsStaffManager implements HrmsStaffService{

	private HrmsStaffDao hrmsStaffDao;
	
	@Autowired
	public HrmsStaffManager(HrmsStaffDao hrmsStaffDao) {
		super();
		this.hrmsStaffDao = hrmsStaffDao;
	}

	@Override
	public DataResult<List<HrmsStaff>> getAll() {
		return new SuccessDataResult<List<HrmsStaff>>
		(this.hrmsStaffDao.findAll(),"HrmsStaffs listed");	
	}

}
