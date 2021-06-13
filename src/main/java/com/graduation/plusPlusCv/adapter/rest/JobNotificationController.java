package com.graduation.plusPlusCv.adapter.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.graduation.plusPlusCv.models.JobNotification;
import com.graduation.plusPlusCv.models.JobPost;
import com.graduation.plusPlusCv.service.JobNotificationService;

@RestController
@RequestMapping ("/job-notification")
@CrossOrigin(origins = "*")
public class JobNotificationController {
@Autowired
JobNotificationService service;


@PostMapping 
public void create(@RequestBody JobNotification jobNotification) {
	service.addJobNotification(jobNotification);
}

@GetMapping("/{id}")
public JobNotification getJobNotificationsById(@PathVariable String id){
	return service.getJobNotificationById(id).get();
}
@GetMapping("user/{id}")
public List<JobNotification> getAllJobNotificationsByUserId(@PathVariable String id){
	return service.getAllJobNotificationByUserId(id);
}
@GetMapping("user-not-viewed-notifications/{id}")
public List<JobNotification> getAllJobNotificationsByUserIdAndNotViewed(@PathVariable String id){
	return service.getAllJobNotificationByUserIdAndNotViewedByUser(id);}

}
