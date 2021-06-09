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

import com.hrms.business.abstracts.PreWritingService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.PreWriting;

@RestController
@RequestMapping("/api/preWritings")
@CrossOrigin
public class PreWritingsController {
	
	private PreWritingService preWritingService;
	
	@Autowired
	public PreWritingsController(PreWritingService preWritingService) {
		super();
		this.preWritingService = preWritingService;
	};
	
	@GetMapping("/getall")
	public DataResult<List<PreWriting>> getAll(){
		return this.preWritingService.getAll();
		}
		
	@GetMapping("/getByJobSeeker")
	public DataResult<List<PreWriting>> getAll(int jobSeekerId){
		return this.preWritingService.getByJobSeekerId(jobSeekerId);
		}
		
	@PostMapping("/add")
	public Result add(@Valid @RequestBody PreWriting preWriting){
	    return this.preWritingService.add(preWriting);
	    }
}
