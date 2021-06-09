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

import com.hrms.business.abstracts.JobSeekerImageService;
import com.hrms.entities.concretes.JobSeeker;
import com.hrms.entities.concretes.JobSeekerImage;

@RestController
@RequestMapping("/api/jobSeekerImages")
@CrossOrigin
public class JobSeekerImagesController {

	private JobSeekerImageService imageService;

	@Autowired
	public JobSeekerImagesController(JobSeekerImageService imageService) {
		super();
		this.imageService = imageService;
	}
	
	@PostMapping(value="/upload")
	public ResponseEntity<?> add(@RequestBody MultipartFile file,@RequestParam int jobSeekerid) throws IOException {
		JobSeekerImage image = new JobSeekerImage();
		JobSeeker jobSeeker = new JobSeeker();
		jobSeeker.setId(jobSeekerid);
		image.setJobSeeker(jobSeeker);
		
		return ResponseEntity.ok(this.imageService.add(file, image));
	}
	
    @GetMapping("/getById")
    public ResponseEntity<?> getById(int id) throws IOException{
        return ResponseEntity.ok(this.imageService.getById(id));
    }
    
    @GetMapping("/getByJobSeekerId")
    public ResponseEntity<?> getByJobSeekerId(int id){
        return ResponseEntity.ok(this.imageService.getByJobSeekerId(id));
    }
	
}
