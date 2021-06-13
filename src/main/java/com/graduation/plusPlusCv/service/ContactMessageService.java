package com.graduation.plusPlusCv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graduation.plusPlusCv.adapter.repo.ContactMessageRepo;
import com.graduation.plusPlusCv.models.ContactMessage;
@Service
public class ContactMessageService {
	@Autowired
	ContactMessageRepo repo ;
	public List<ContactMessage> getAll(){
			
			return repo.getAllMessages();
		}
public Optional<ContactMessage> createMessage(ContactMessage message){
	return repo.createMessage(message);
}
}
