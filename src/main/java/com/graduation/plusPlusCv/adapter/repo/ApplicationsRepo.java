package com.graduation.plusPlusCv.adapter.repo;

import java.util.List;
import java.util.Optional;

import com.graduation.plusPlusCv.models.Applications;
import com.graduation.plusPlusCv.models.JobPost;


public interface ApplicationsRepo {
  
     Optional<Applications>createApplication(Applications applicationInfo);
     Optional<Applications>getApplicationById(String id);
     List<Applications>getAllApplicationsByUserId(String userId);
     List<Applications>getAllApplicationsByJobPost(String jobPostId);
     List<Applications>getAllApplications();
}
