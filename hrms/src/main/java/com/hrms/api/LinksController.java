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

import com.hrms.business.abstracts.LinkService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.Link;

@RestController
@RequestMapping("/api/links")
@CrossOrigin
public class LinksController {
	
	private LinkService linkService;

	@Autowired
	public LinksController(LinkService linkService) {
		super();
		this.linkService = linkService;
	};
	
	@GetMapping("/getall")
	public DataResult<List<Link>> getAll(){
		return this.linkService.getAll();
	}
	
	@GetMapping("/getByJobSeeker")
	public DataResult<List<Link>> getByJobSeekerId(int jobSeekerId){
		return this.linkService.getByJobSeekerId(jobSeekerId);
	}
	
    @PostMapping("/add")
    public Result add(@Valid @RequestBody Link link){
        return this.linkService.add(link);
    }
}
