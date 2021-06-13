package com.graduation.plusPlusCv.adapter.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.graduation.plusPlusCv.models.JobNotification;

@Repository
public interface JobNotificationMangoRepo extends MongoRepository<JobNotification, String>{
	List<JobNotification> findAllByUserId(String id);
	List<JobNotification> findAllByUserIdAndViewedByUser(String id , Boolean viewedByUser);
	

	

}
