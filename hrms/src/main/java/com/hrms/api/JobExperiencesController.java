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

import com.hrms.business.abstracts.JobExperienceService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.JobExperience;

@RestController
@RequestMapping("/api/jobExperiences")
@CrossOrigin
public class JobExperiencesController {
	
	private JobExperienceService jobExperienceService;
	
	@Autowired
	public JobExperiencesController(JobExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobExperience>> getAll(){
		return this.jobExperienceService.getAll();
	}
	
    @PostMapping("/add")
    public Result add(@Valid @RequestBody JobExperience jobExperience){
        return this.jobExperienceService.add(jobExperience);
    }
    
	@GetMapping("/getByJobSeekerIdOrderByDateOfEndASC")
	public DataResult<List<JobExperience>> getByJobSeekerIdOrderByDateOfEndASC(int jobSeekerId){
		return this.jobExperienceService.getByJobSeekerIdOrderByDateOfEndASC(jobSeekerId);
	}
	
	@GetMapping("/getByJobSeekerIdOrderByDateOfEndDESC")
	public DataResult<List<JobExperience>> getByJobSeekerIdOrderByDateOfEndDESC(int jobSeekerId){
		return this.jobExperienceService.getByJobSeekerIdOrderByDateOfEndDESC(jobSeekerId);
	}

}
