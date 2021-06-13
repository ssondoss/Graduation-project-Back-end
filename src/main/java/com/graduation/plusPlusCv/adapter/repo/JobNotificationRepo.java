package com.graduation.plusPlusCv.adapter.repo;

import java.util.List;
import java.util.Optional;

import com.graduation.plusPlusCv.models.JobNotification;

public interface JobNotificationRepo {
	List<JobNotification> getAllNotificationsByUserId(String id);
    void createJobNotification(JobNotification jobNotification);  
    Optional<JobNotification> getJobNotificationById(String id) ;
	List<JobNotification> getAllNotificationsByUserIdAndNotViewedByUser(String id);

}
