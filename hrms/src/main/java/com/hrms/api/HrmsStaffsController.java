package com.hrms.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.business.abstracts.HrmsStaffService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.entities.concretes.HrmsStaff;

@RestController
@RequestMapping("/api/hrmsstaffs")
public class HrmsStaffsController {
	private HrmsStaffService hrmsStaffService;

	public HrmsStaffsController(HrmsStaffService hrmsStaffService) {
		super();
		this.hrmsStaffService = hrmsStaffService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<HrmsStaff>> getAll(){
		return this.hrmsStaffService.getAll();
	}

}
