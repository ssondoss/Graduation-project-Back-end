package com.graduation.plusPlusCv.adapter.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.graduation.plusPlusCv.models.JobPost;
@Repository
public interface JobPostMongoRepo extends MongoRepository<JobPost, String>{
	List<JobPost> findAllByUserId(String id);

}
