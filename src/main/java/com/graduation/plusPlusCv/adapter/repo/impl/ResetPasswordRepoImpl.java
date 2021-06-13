package com.graduation.plusPlusCv.adapter.repo.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.graduation.plusPlusCv.adapter.repo.ResetPasswordMongoRepo;
import com.graduation.plusPlusCv.adapter.repo.ResetPasswordRepo;
import com.graduation.plusPlusCv.models.ResetPassword;

@Component
public class ResetPasswordRepoImpl implements ResetPasswordRepo{

	@Autowired
	ResetPasswordMongoRepo repo;
	
	@Override
	public Optional<ResetPassword> add(ResetPassword resetPassword) {
		
		return Optional.of(repo.save(resetPassword));
	}

	@Override
	public Optional<ResetPassword> getById(String id) {
		
		return repo.findById(id);
	}

	@Override
	public Optional<ResetPassword> Update(ResetPassword resetPassword) {
		return Optional.of(repo.save(resetPassword));
	}

	@Override
	public Optional<ResetPassword> getByCodeAndUserId(String code, String userId) {
		return repo.findResetPasswordByCodeAndUserId(code, userId);
	}

}
