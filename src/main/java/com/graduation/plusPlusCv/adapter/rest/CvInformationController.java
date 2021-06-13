package com.graduation.plusPlusCv.adapter.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.graduation.plusPlusCv.models.CvInformation;
import com.graduation.plusPlusCv.service.CvService;

@RestController
@RequestMapping ("/cv-info")
@CrossOrigin(origins = "*")
public class CvInformationController {
	@Autowired
	CvService service;
	
	@PostMapping
	public boolean add(@RequestBody CvInformation cvInformation) {
		return service.add(cvInformation);
	}
     @GetMapping
     public List<CvInformation> getAll(){
    	 
    	 return service.getAll();
     }
     
     @GetMapping("/cv-by-user-id/{id}")
     CvInformation getByUserId(@PathVariable String id) {
    	 return service.getByUserId(id);
     }
     
     @PutMapping("/update-cv-template/{id}/{newTemplate}")
     CvInformation updateCvTemplate(@PathVariable String id , @PathVariable String newTemplate ) {
    	 return service.updateCvTemplate(id,newTemplate);
     }
    	 
     

}
