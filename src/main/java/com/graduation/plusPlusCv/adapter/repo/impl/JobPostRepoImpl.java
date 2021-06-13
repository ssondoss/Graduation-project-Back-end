package com.graduation.plusPlusCv.adapter.repo.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.graduation.plusPlusCv.adapter.repo.JobPostMongoRepo;
import com.graduation.plusPlusCv.adapter.repo.JobPostRepo;
import com.graduation.plusPlusCv.models.JobPost;

@Component
public class JobPostRepoImpl implements JobPostRepo {
	@Autowired
	JobPostMongoRepo repo;

	@Override
	public List<JobPost> getAllPosts() {
    		return repo.findAll();
	}

	@Override
	public Optional<JobPost> getById(String id) {
		return repo.findById(id);
	}

	@Override
	public void addJobPost(JobPost jobPost) {
repo.save(jobPost)		;
	}

	@Override
	public List<JobPost> findAllByUserId(String id) {
		
		return repo.findAllByUserId(id);
	}

	@Override
	public List<JobPost> findAllByStatus() {
		return repo.findAll();
	}

}
