package com.graduation.plusPlusCv.adapter.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.graduation.plusPlusCv.models.CvInformation;
@Repository

public interface CvInformationMangoRepo extends MongoRepository<CvInformation, String>{

	Optional<CvInformation> findByUserId(String id); 
    List<CvInformation> findAllByRoleContainingIgnoreCaseOrUserSkillsIn(String role, List<String> skills);

}
