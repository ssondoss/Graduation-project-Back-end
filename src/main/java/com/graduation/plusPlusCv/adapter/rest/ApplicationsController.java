package com.graduation.plusPlusCv.adapter.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.graduation.plusPlusCv.models.Applications;
import com.graduation.plusPlusCv.service.ApplicationsService;
import com.graduation.plusPlusCv.service.DTOs.CreateNewApplicationsDTO;


@RestController
@RequestMapping ("/applications")
@CrossOrigin(origins = "*")
public class ApplicationsController {
	@Autowired
	ApplicationsService service;
	
	    @GetMapping
	    public List<Applications> getAllApplications(){
	        return service.getAllApplications();
	    }

	    @GetMapping("get-all-applications-by-user/{id}")
	    public List<Applications> getAllApplicationsByUserId(@PathVariable String id){
	        return service.getAllApplicationsByUserId(id);
	    }

	    @PostMapping
	    public  Applications createApplication(@RequestBody CreateNewApplicationsDTO applicationInfo){
	        return service.createApplication(applicationInfo.getUserId(),applicationInfo.getJobPostId());
	    }

	  
	    @GetMapping("get-all-applications-by-job-post/{id}")
	    public List<Applications> getAllApplicationsByJobPost (@PathVariable String id ) {
	     return	service.getAllApplicationsByJobPost(id);
	    	
	    }
	    
	    @GetMapping("/{id}")
	    public Applications getApplicationById(@PathVariable String id){
	        return service.getApplicationById(id);
	    }
	    
	    @PutMapping("/{id}")
	    public Applications updateApplicationStatus(@PathVariable String id) {
	    	return service.updateApplicationStatus(id);
	    	
	    }

	    
	  
}
