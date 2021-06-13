package com.graduation.plusPlusCv.adapter.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.graduation.plusPlusCv.models.JobPost;
import com.graduation.plusPlusCv.service.JobPostService;

@RestController
@RequestMapping ("/job-post")
@CrossOrigin(origins = "*")
public class JobPostController {
	@Autowired
	JobPostService service;
	
	@PostMapping 
	public void add(@RequestBody JobPost jobPost) {
		service.addJobPost(jobPost);
	}
	
	@GetMapping
	public List<JobPost> getAllJobPosts(){
		return service.getAllPosts();
	}
	
	@GetMapping("/{id}")
	public JobPost getJobPostById(@PathVariable String id){
		return service.getById(id).get();
	}
	@GetMapping("user/{id}")
    public List<JobPost> getAllJobPostsByUserId(@PathVariable String id){
		return service.getAllPostsByUserId(id);
		
	}
	@PutMapping("/{id}")
    public JobPost updateStatus(@PathVariable String id , @RequestParam Boolean status) {
		return service.updateStatus(id , status);
	}
}
