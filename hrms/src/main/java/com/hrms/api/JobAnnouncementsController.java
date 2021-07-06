package com.hrms.api;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.business.abstracts.JobAnnouncementService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.Result;
import com.hrms.entities.concretes.JobAnnouncement;

@RestController
@RequestMapping("api/jobAnnouncements")
@CrossOrigin
public class JobAnnouncementsController {

	private JobAnnouncementService jobAnnouncementService;

	@Autowired 
	public JobAnnouncementsController(JobAnnouncementService jobAnnouncementService) {
		super();
		this.jobAnnouncementService = jobAnnouncementService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAnnouncement>> getAll(){
		return this.jobAnnouncementService.getAll();
	}
	
    @PostMapping("/add")
    public Result add(@Valid @RequestBody JobAnnouncement jobAnnouncement){
        return this.jobAnnouncementService.add(jobAnnouncement);
    }
    
    @GetMapping("/getByActive")
    public DataResult<List<JobAnnouncement>> getByIsActiveTrue() {
        return this.jobAnnouncementService.getByIsActiveTrue();
    }
    
    @GetMapping("/getById")
    public DataResult<JobAnnouncement> getById(int id) {
        return this.jobAnnouncementService.getById(id);
    }
    
    @GetMapping("/getByIsActiveTrueAndDepartment_Id")
    public DataResult<List<JobAnnouncement>> getByIsActiveTrueAndDepartment_Id(int id) {
        return this.jobAnnouncementService.getByIsActiveTrueAndDepartment_Id(id);
    }
    
    @GetMapping("/getByIsActiveTrueAndCity_Id")
    public DataResult<List<JobAnnouncement>> getByIsActiveTrueAndCity_Id(int id) {
        return this.jobAnnouncementService.getByIsActiveTrueAndCity_Id(id);
    }
    
    @GetMapping("/getByApplicationDeadline")
    public DataResult<List<JobAnnouncement>> getByApplicationDeadline(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return this.jobAnnouncementService.getByApplicationDeadlineLessThanEqual(date);
    }
    
    @GetMapping("/getByActiveAndApplicationDeadline")
    public DataResult<List<JobAnnouncement>> getByIsActiveTrueAndApplicationDeadlineLessThanEqual(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return this.jobAnnouncementService.getByIsActiveTrueAndApplicationDeadlineLessThanEqual(date);
    }
    
    @GetMapping("/getByActiveAndCompanyName")
    public DataResult<List<JobAnnouncement>> getByIsActiveAndEmployer_CompanyName(@RequestParam String companyName) {
        return this.jobAnnouncementService.getByIsActiveTrueAndEmployer_CompanyName(companyName);
    }
    
    @GetMapping("/getByEmployer")
    public DataResult<List<JobAnnouncement>> getByEmployer(@RequestParam int id) {
        return this.jobAnnouncementService.getByEmployerId(id);
    }
    
    @GetMapping("/changeStatus")
    public DataResult<JobAnnouncement> changeStatus(@RequestParam int employerId,@RequestParam int announcementId,@RequestParam boolean status) {
        return this.jobAnnouncementService.changeStatus(employerId,announcementId,status);
    }
	
}
