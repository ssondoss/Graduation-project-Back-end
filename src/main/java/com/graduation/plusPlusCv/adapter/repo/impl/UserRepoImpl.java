package com.graduation.plusPlusCv.adapter.repo.impl;

import com.graduation.plusPlusCv.adapter.repo.UserMongoRepo;
import com.graduation.plusPlusCv.adapter.repo.UserRepo;
import com.graduation.plusPlusCv.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserRepoImpl implements UserRepo {

    @Autowired
    private UserMongoRepo userMongoRepo;

    @Override
    public Optional<User> getUserById(String id) {
        Optional<User> user = userMongoRepo.findById(id);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users= userMongoRepo.findAll();
        return users;
    }

    @Override
    public Optional<User> addUser(User user) {
        userMongoRepo.save(user);
        return Optional.of(user);
    }

    @Override
    public void deleteUserById(String id) {
        userMongoRepo.deleteById(id);
    }

    @Override
    public Optional<User> findUserByEmailAndPassword(String email, String password) {
        Optional<User> user = userMongoRepo.findUserByEmailAndPassword(email , password);
        return user;
    }

	@Override
	public Optional<User> findUserByEmail(String email) {
		return userMongoRepo.findUserByEmail(email);
	}
}
