package com.graduation.plusPlusCv.adapter.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.graduation.plusPlusCv.models.ResetPassword;

@Repository
public interface ResetPasswordMongoRepo extends MongoRepository<ResetPassword, String> {
	Optional<ResetPassword> findResetPasswordByCodeAndUserId(String code,String userId);
}
