package com.graduation.plusPlusCv.adapter.repo;

import java.util.List;
import java.util.Optional;

import com.graduation.plusPlusCv.models.JobPost;

public interface JobPostRepo {
	
	List<JobPost> getAllPosts() ;
	Optional<JobPost> getById(String id);
	void addJobPost(JobPost jobPost);
	List<JobPost> findAllByUserId(String id);
	List<JobPost> findAllByStatus() ;

}
