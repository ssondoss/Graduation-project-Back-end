package com.graduation.plusPlusCv.adapter.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.graduation.plusPlusCv.models.ResetPassword;
import com.graduation.plusPlusCv.service.ResetPasswordService;

@RestController
@RequestMapping("/reset-password")
@CrossOrigin(origins = "*")
public class ResetPasswordController {
	@Autowired
	ResetPasswordService service;
	
	@PostMapping
	public ResetPassword createResetPassword(@RequestParam String email) {
		return service.add(email);
	}
	
	@GetMapping
	public ResetPassword getByCodeAndUserId(@RequestParam String code,@RequestParam String userId) {
		return service.getByCodeAndUserId(code, userId);
	}
	
	@PutMapping("{id}")
	public ResetPassword getByCodeAndUserId(@PathVariable String id) {
		return service.update(id);
	}

}
