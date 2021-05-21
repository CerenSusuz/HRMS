package com.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.business.abstracts.DepartmentService;
import com.hrms.entities.concretes.Department;

@RestController
@RequestMapping("/api/departments")
public class DepartmentsController {
	
	private DepartmentService departmentService;
	
	@Autowired 
	public DepartmentsController(DepartmentService departmentService) {
		super();
		this.departmentService = departmentService;
	}
	
	@GetMapping("/getall")
	public List<Department> getAll(){
		return this.departmentService.getAll();
	}

}
