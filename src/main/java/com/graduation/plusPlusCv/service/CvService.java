package com.graduation.plusPlusCv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graduation.plusPlusCv.adapter.repo.CvInformationRepo;
import com.graduation.plusPlusCv.models.CvInformation;

@Service
public class CvService {
	@Autowired
	CvInformationRepo repo ;
	
	public boolean add(CvInformation cvInformation) {
		Optional<CvInformation> cvCandidate = repo.getUserById(cvInformation.getUser().getId());
		if(cvCandidate.isPresent()) {
			cvInformation.setId(cvCandidate.get().getId());
			 Optional<CvInformation>cvInfo=repo.addCvInfo(cvInformation);
			   if(cvInfo.isPresent()) { 
				return true;}
			   else return false;
		}else {
	   Optional<CvInformation>cvInfo=repo.addCvInfo(cvInformation);
	   if(cvInfo.isPresent()) { 
		return true;}
	   else return false;}
	   
	}
	public List<CvInformation> getAll(){
		
		return repo.getAll();
	}
	
	public CvInformation getByUserId(String id){
		Optional<CvInformation> cvCandidate = repo.getUserById(id);
		if(cvCandidate.isEmpty()) {
			throw new RuntimeException("USER_NOT_FOUND");
		}
		return cvCandidate.get();
	}
	
	public CvInformation updateCvTemplate(String id , String newTemplate) {
		Optional<CvInformation> cvInformationOptional = repo.getUserById(id) ;
		
		if(cvInformationOptional.isEmpty()) {
			throw new RuntimeException("CV_NOT_FOUND");
		}
		CvInformation cv = cvInformationOptional.get();
		cv.setCvTemplate(newTemplate);
		repo.addCvInfo(cv);
		return cv;
		
	}

}
