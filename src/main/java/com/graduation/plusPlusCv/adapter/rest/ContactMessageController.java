package com.graduation.plusPlusCv.adapter.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.graduation.plusPlusCv.models.ContactMessage;
import com.graduation.plusPlusCv.service.ContactMessageService;
@RestController
@RequestMapping ("/contact-message")
@CrossOrigin(origins = "*")
public class ContactMessageController {
	@Autowired
	ContactMessageService service;
	  @PostMapping
	    public  ContactMessage createApplication(@RequestBody ContactMessage message){
	        return service.createMessage(message).get();
	    }
	  @GetMapping
	    public List<ContactMessage> getAllContactMessage(){
	        return service.getAll();
	    }

}
