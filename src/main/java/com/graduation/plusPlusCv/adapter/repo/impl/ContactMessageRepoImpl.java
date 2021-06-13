package com.graduation.plusPlusCv.adapter.repo.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.graduation.plusPlusCv.adapter.repo.ContactMessageMangoRepo;
import com.graduation.plusPlusCv.adapter.repo.ContactMessageRepo;
import com.graduation.plusPlusCv.models.ContactMessage;
@Component
public class ContactMessageRepoImpl implements ContactMessageRepo {
	@Autowired
	ContactMessageMangoRepo repo;

	@Override
	public Optional<ContactMessage> createMessage(ContactMessage message) {
     repo.save(message);
         return Optional.of(message);
	}

	@Override
	public List<ContactMessage> getAllMessages() {
		return repo.findAll();
	}
}
