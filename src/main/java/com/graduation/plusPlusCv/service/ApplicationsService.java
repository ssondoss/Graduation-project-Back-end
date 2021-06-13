package com.graduation.plusPlusCv.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graduation.plusPlusCv.adapter.repo.ApplicationsRepo;
import com.graduation.plusPlusCv.adapter.repo.JobPostRepo;
import com.graduation.plusPlusCv.adapter.repo.UserRepo;
import com.graduation.plusPlusCv.models.Applications;
import com.graduation.plusPlusCv.models.JobPost;
import com.graduation.plusPlusCv.models.User;

@Service
public class ApplicationsService {
	@Autowired
	ApplicationsRepo repo;
	@Autowired
	UserRepo userRepo;
	@Autowired
	JobPostRepo jobPostRepo;
	
	
	public Applications createApplication(String userId , String jobPostId) {
		Optional<User> userOptional = userRepo.getUserById(userId);
		
		Optional<JobPost> jobPostOptional = jobPostRepo.getById(jobPostId);
		
		 if(userOptional.isEmpty() || jobPostOptional.isEmpty()) {
			 throw new RuntimeException("WRONG_ID");
		 }
		 
		 Applications newApplication = Applications.builder()
				 .id(UUID.randomUUID().toString())
				 .user(userOptional.get())
				 .jobPost(jobPostOptional.get())
				 .appliedDate(LocalDateTime.now()).viewedByPublisher(false)
				 .build();
	
		Optional<Applications> applicationOptional = repo.createApplication(newApplication);
		if(applicationOptional.isEmpty()) {
			throw new RuntimeException("");
		}
		return applicationOptional.get();
	}

	public Applications getApplicationById(String id) {
		Optional<Applications> applicationOptional = repo.getApplicationById(id);
		if(applicationOptional.isEmpty()) {
			throw new RuntimeException("APPLICATION_NOT_EXSIST");
		}
		return applicationOptional.get();
	}

	public List<Applications> getAllApplicationsByUserId(String userId) {
		return repo.getAllApplicationsByUserId(userId);
	}

	
	public List<Applications> getAllApplicationsByJobPost(String jobPostId) {
		return repo.getAllApplicationsByJobPost(jobPostId);
	}

	
	public List<Applications> getAllApplications() {
		return repo.getAllApplications();
	}
	public Applications updateApplicationStatus(String id) {
	  Applications application=	this.getApplicationById(id);
	  application.setViewedByPublisher(true);
	  repo.createApplication(application);
		return  application;
	}
	

}
