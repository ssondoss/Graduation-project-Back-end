package com.graduation.plusPlusCv.adapter.repo;

import java.util.List;
import java.util.Optional;


import com.graduation.plusPlusCv.models.ContactMessage;

public interface ContactMessageRepo {
	  Optional<ContactMessage>createMessage(ContactMessage message);

	     List<ContactMessage>getAllMessages();
}
