package com.graduation.plusPlusCv.adapter.repo.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.graduation.plusPlusCv.adapter.repo.ApplicationsMangoRepo;
import com.graduation.plusPlusCv.adapter.repo.ApplicationsRepo;
import com.graduation.plusPlusCv.models.Applications;

@Component
public class ApplicationsRepoImpl implements ApplicationsRepo{

	
	@Autowired
	ApplicationsMangoRepo repo;
	@Override
	public Optional<Applications> createApplication(Applications applicationInfo) {
		return Optional.of(repo.save(applicationInfo));
	}

	@Override
	public Optional<Applications> getApplicationById(String id) {
		
		return repo.findById(id);
	}

	@Override
	public List<Applications> getAllApplicationsByUserId(String userId) {
		return repo.findAllByUserId(userId);
	}

	@Override
	public List<Applications> getAllApplicationsByJobPost(String jobPostId) {
		
		return repo.findAllByJobPostId(jobPostId);
	}

	@Override
	public List<Applications> getAllApplications() {
		
		return repo.findAll();
	}

	
}
