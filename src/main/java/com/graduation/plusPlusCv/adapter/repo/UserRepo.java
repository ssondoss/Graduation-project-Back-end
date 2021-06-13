package com.graduation.plusPlusCv.adapter.repo;

import com.graduation.plusPlusCv.models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepo {
    Optional<User> getUserById(String id);
    List<User> getAllUsers();
    Optional<User> addUser(User user);
    void deleteUserById(String id);
    Optional<User> findUserByEmailAndPassword(String email , String password);
    Optional<User> findUserByEmail(String email );

}

