package com.hrms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.business.abstracts.SchoolService;

@RestController
@RequestMapping("/api/schools")
public class SchoolsController {
	
	private SchoolService schoolService;

	 @Autowired
	public SchoolsController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	};
	
}
