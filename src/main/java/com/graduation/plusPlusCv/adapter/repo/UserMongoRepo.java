package com.graduation.plusPlusCv.adapter.repo;

import com.graduation.plusPlusCv.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserMongoRepo extends MongoRepository<User, String> {
    Optional<User> findUserByEmailAndPassword(String email , String password);
    Optional<User> findUserByEmail(String email );


}
