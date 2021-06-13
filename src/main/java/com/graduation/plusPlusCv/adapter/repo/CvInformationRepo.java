package com.graduation.plusPlusCv.adapter.repo;

import java.util.List;
import java.util.Optional;
import com.graduation.plusPlusCv.models.CvInformation;

public interface CvInformationRepo  {
    Optional<CvInformation> addCvInfo(CvInformation cvInfo);
    Optional<CvInformation> getUserById(String id);
    Optional<CvInformation> getCvById(String id);
    List<CvInformation> getAll();
    List<CvInformation> findAllByRoleOrUserSkills(String role, List<String> skills);



}
