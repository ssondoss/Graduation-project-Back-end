package com.graduation.plusPlusCv.adapter.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.graduation.plusPlusCv.models.Applications;

@Repository
public interface ApplicationsMangoRepo extends MongoRepository<Applications, String>{

	 List<Applications> findAllByUserId(String userId);
	 List<Applications> findAllByJobPostId(String id);
	 
	
}
