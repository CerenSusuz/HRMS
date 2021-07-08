package com.hrms.api;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hrms.business.abstracts.CompanyLogoService;
import com.hrms.entities.concretes.CompanyLogo;
import com.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/companyLogos")
@CrossOrigin
public class CompanyLogoController {
	
	private CompanyLogoService logoService;
	
    @Autowired
	public CompanyLogoController(CompanyLogoService logoService) {
		super();
		this.logoService = logoService;
	}
	
    @PostMapping(value="/upload")
	public ResponseEntity<?> add(@RequestBody MultipartFile file,@RequestParam int employerId) throws IOException {
		CompanyLogo logo = new CompanyLogo();
		Employer employer = new Employer();
		employer.setId(employerId);
		logo.setEmployer(employer);
		
		return ResponseEntity.ok(this.logoService.add(file, logo));
	}
	
    @GetMapping("/getById")
    public ResponseEntity<?> getById(int id) throws IOException{
        return ResponseEntity.ok(this.logoService.getById(id));
    }
    
    @GetMapping("/getByEmployerId")
    public ResponseEntity<?> getByJobSeekerId(int id){
        return ResponseEntity.ok(this.logoService.getByEmployerId(id));
    }
	

}
