package com.graduation.plusPlusCv.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graduation.plusPlusCv.adapter.repo.CvInformationRepo;
import com.graduation.plusPlusCv.adapter.repo.JobNotificationRepo;
import com.graduation.plusPlusCv.adapter.repo.JobPostRepo;
import com.graduation.plusPlusCv.models.CvInformation;
import com.graduation.plusPlusCv.models.JobNotification;
import com.graduation.plusPlusCv.models.JobPost;

@Service
public class JobPostService {
	@Autowired
	JobPostRepo repo ;
	@Autowired
	CvInformationRepo cvRepo;
	@Autowired
	JobNotificationRepo notificationRepo;
	public List<JobPost> getAllPosts() {
			List<JobPost> all = repo.findAllByStatus();
			List<JobPost> res=new ArrayList<JobPost>();
			
			for (JobPost jobPost : all) {
				if(jobPost.getStatus()) 
					res.add(jobPost);
			}
			
			return res;
    }
	public Optional<JobPost> getById(String id) {
		return repo.getById(id);
	}
	public void addJobPost(JobPost jobPost) {
       repo.addJobPost(jobPost);
       List<CvInformation> users = cvRepo.findAllByRoleOrUserSkills(jobPost.getJobRole(), jobPost.getSkills());
       System.out.println(users.size());
       for (CvInformation cvInformation:users) {
    	   System.out.print(cvInformation.getId());
    	   JobNotification jobNotification = JobNotification.builder()
    			   .id(UUID.randomUUID().toString())
    			   .user(cvInformation.getUser())
    			   .viewedByUser(false)
    			   .jobPost(jobPost)
    			   .dateAndTime(LocalDateTime.now())
    			   .build();

    	   notificationRepo.createJobNotification(jobNotification);
	}
       
	}

	public List<JobPost> getAllPostsByUserId(String id) {
		return repo.findAllByUserId(id);
	}
	
	public JobPost updateStatus(String id , Boolean status) {
		if(repo.getById(id).isEmpty()) {
			throw new RuntimeException("JOB POST NOT FOUND");
		}
		else 
		{
			JobPost jobPost=repo.getById(id).get();
			jobPost.setStatus(status);
			repo.addJobPost(jobPost);
			return jobPost;

		}
	}
	
	

}
