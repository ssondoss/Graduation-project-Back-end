package com.graduation.plusPlusCv.adapter.repo.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.graduation.plusPlusCv.adapter.repo.ApplicationsMangoRepo;
import com.graduation.plusPlusCv.adapter.repo.JobNotificationMangoRepo;
import com.graduation.plusPlusCv.adapter.repo.JobNotificationRepo;
import com.graduation.plusPlusCv.models.JobNotification;
@Component
public class JobNotificationRepoImpl  implements JobNotificationRepo{
	@Autowired
	JobNotificationMangoRepo repo;
	@Override
	public List<JobNotification> getAllNotificationsByUserId(String id) {
		return repo.findAllByUserId(id);
	}

	@Override
	public void createJobNotification(JobNotification jobNotification) {
      repo.save(jobNotification);
	}

	@Override
	public Optional<JobNotification> getJobNotificationById(String id) {
		return  repo.findById(id);
	}

	@Override
	public List<JobNotification> getAllNotificationsByUserIdAndNotViewedByUser(String id  ) {
		return repo.findAllByUserIdAndViewedByUser(id , false); 
	}
}
