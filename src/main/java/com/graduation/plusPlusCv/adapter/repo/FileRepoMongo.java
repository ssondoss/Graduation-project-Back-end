package com.graduation.plusPlusCv.adapter.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.graduation.plusPlusCv.models.File;

@Repository
public interface FileRepoMongo extends MongoRepository<File, String> {
}
