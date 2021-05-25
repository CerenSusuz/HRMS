package com.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.business.abstracts.DepartmentService;
import com.hrms.core.utilities.business.BusinessRules;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.ErrorResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.core.utilities.results.SuccessResult;
import com.hrms.dataAccess.abstracts.DepartmentDao;
import com.hrms.entities.concretes.Department;

@Service
public class DepartmentManager implements DepartmentService {

	private DepartmentDao departmentDao;
	
	@Autowired
	public DepartmentManager(DepartmentDao departmentDao) {
		super();
		this.departmentDao = departmentDao;
	}

	@Override
	public DataResult<List<Department>> getAll() {
		return new SuccessDataResult<List<Department>>
		(this.departmentDao.findAll(),"Departments listed");		}

	@Override
	public Result add(Department department) {
	
		Result result = BusinessRules.run(checkDepartment(department.getName()));

		if (result != null) {
			return result;
		}
		
		this.departmentDao.save(department);
		return new SuccessResult("Department add ok");
	}
	
	//check rules
	
	private Result checkDepartment(String name) {
		List<Department> list = this.departmentDao.findAll();
		for (Department department: list) {
			if (department.getName() == name) {
				return new ErrorResult("ERROR");
			}
		}
		return new SuccessResult();
	}
	

}
