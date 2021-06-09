package com.hrms.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.business.abstracts.DepartmentService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.Department;

@RestController
@RequestMapping("/api/departments")
@CrossOrigin
public class DepartmentsController {
	
	private DepartmentService departmentService;
	
	@Autowired 
	public DepartmentsController(DepartmentService departmentService) {
		super();
		this.departmentService = departmentService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Department>> getAll(){
		return this.departmentService.getAll();
	}
	
    @PostMapping("/add")
    public Result add(@Valid @RequestBody Department department){
        return this.departmentService.add(department);
    }

}
