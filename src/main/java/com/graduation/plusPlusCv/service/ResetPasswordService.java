package com.graduation.plusPlusCv.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graduation.plusPlusCv.adapter.repo.ResetPasswordRepo;
import com.graduation.plusPlusCv.adapter.repo.UserRepo;
import com.graduation.plusPlusCv.models.ResetPassword;
import com.graduation.plusPlusCv.models.User;
import com.graduation.plusPlusCv.util.EmailServiceImpl;

@Service
public class ResetPasswordService  {

	@Autowired 
	ResetPasswordRepo resetRepo;
	@Autowired
	UserRepo userRepo;
	@Autowired 
	EmailServiceImpl emailService;
	public ResetPassword add(String email) {
		Optional<User> userOptional = userRepo.findUserByEmail(email);
		String code =UUID.randomUUID().toString();
		String id =UUID.randomUUID().toString();
		if(userOptional.isPresent()) {
			User user = userOptional.get();
			ResetPassword resetPassword = ResetPassword.builder()
					.id(id)
					.code(code)
					.userId(user.getId())
					.isUsed(false)
					.build();
			String messegeBody = "Hi "+user.getFullName()+", your reset password link is http://localhost:4200/reset-password?user-id="+user.getId()+"&code="+code;
			emailService.sendSimpleMessage(email,"Reset password link from PlusPlusCV",messegeBody );
			resetRepo.add(resetPassword);
			return resetPassword;
		}else {
		throw new RuntimeException("USER_NOT_FOUND");
		}
		
	}

	
	public ResetPassword getById(String id) {
		 if(resetRepo.getById(id).isPresent()) {
			 return resetRepo.getById(id).get();
		 }else {
				throw new RuntimeException("RESET_LNIK_NOT_FOUND");
		 }
	}

	public ResetPassword getByCodeAndUserId(String code,String userId) {
		 if(resetRepo.getByCodeAndUserId(code,userId).isPresent()) {
			 return resetRepo.getByCodeAndUserId(code,userId).get();
		 }else {
				throw new RuntimeException("RESET_LNIK_NOT_FOUND");
		 }
	}
	public ResetPassword update(String id) {
		 if(resetRepo.getById(id).isPresent()) {
			 ResetPassword resetPassword = resetRepo.getById(id).get();
			 resetPassword.setIsUsed(true);
			 resetRepo.add(resetPassword);
			 return resetPassword;
		 }else {
				throw new RuntimeException("RESET_LNIK_NOT_FOUND");
		 }
	}

}
