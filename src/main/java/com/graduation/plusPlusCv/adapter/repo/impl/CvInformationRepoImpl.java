package com.graduation.plusPlusCv.adapter.repo.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.graduation.plusPlusCv.adapter.repo.CvInformationMangoRepo;
import com.graduation.plusPlusCv.adapter.repo.CvInformationRepo;
import com.graduation.plusPlusCv.models.CvInformation;

@Component
public class CvInformationRepoImpl implements CvInformationRepo {

	@Autowired
	private CvInformationMangoRepo repo;
	
	@Override
	public Optional<CvInformation> addCvInfo(CvInformation cvInfo) {
		 repo.save(cvInfo);
		return Optional.of(cvInfo);
	}

	@Override
	public Optional<CvInformation> getUserById(String id) {
		return repo.findByUserId(id);
	}

	@Override
	public Optional<CvInformation> getCvById(String id) {
		return repo.findById(id);
	}

	@Override
	public List<CvInformation> getAll() {
		
		return repo.findAll();
	}

	@Override
	public List<CvInformation> findAllByRoleOrUserSkills(String role,List<String> skills) {
		
		return repo.findAllByRoleContainingIgnoreCaseOrUserSkillsIn(role, skills);
	}

}
