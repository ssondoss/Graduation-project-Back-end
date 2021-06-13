package com.graduation.plusPlusCv.adapter.repo;

import java.util.Optional;

import com.graduation.plusPlusCv.models.ResetPassword;
import com.graduation.plusPlusCv.models.User;

public interface ResetPasswordRepo {
	
	Optional<ResetPassword> add(ResetPassword resetPassword);
	Optional<ResetPassword> getById(String id);
	Optional<ResetPassword> Update(ResetPassword resetPassword);
	Optional<ResetPassword> getByCodeAndUserId(String code, String userId);


}
