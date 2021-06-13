package com.graduation.plusPlusCv.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graduation.plusPlusCv.adapter.repo.JobNotificationRepo;
import com.graduation.plusPlusCv.models.JobNotification;
@Service
public class JobNotificationService {
@Autowired
JobNotificationRepo repo;

public List<JobNotification> getAllJobNotificationByUserId(String id) {
	List<JobNotification> all =repo.getAllNotificationsByUserId(id);
	List<JobNotification> res= new ArrayList<JobNotification>();
	for (JobNotification jobNotification : all) {
		if(jobNotification.getJobPost().getStatus())
			res.add(jobNotification);
	}
	return res;
}

public Optional<JobNotification> getJobNotificationById(String id) {
	return repo.getJobNotificationById(id);
}

public void addJobNotification(JobNotification jobNotification) {
   repo.createJobNotification(jobNotification);
}

public List<JobNotification> getAllJobNotificationByUserIdAndNotViewedByUser(String id) {
	return repo.getAllNotificationsByUserIdAndNotViewedByUser(id);
}

public void changeNotificationToViewed(String id) {
	Optional<JobNotification> jobNotification = repo.getJobNotificationById(id);
	if(jobNotification.isPresent()) {
		JobNotification jobNotification2 = jobNotification.get();
		jobNotification2.setViewedByUser(true);
		repo.createJobNotification(jobNotification2);
}
	
	else throw new RuntimeException("JOB_NOTIFICATION_NOT_FOUND");
}}
