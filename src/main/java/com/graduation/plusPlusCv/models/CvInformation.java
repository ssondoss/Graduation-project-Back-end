package com.graduation.plusPlusCv.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.graduation.plusPlusCv.service.DTOs.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CvInformation {
	@Id
	private String id;
	private UserDTO user;
	private String name ;
	private String about;
	private String role;
	private String video;
	private String email;
	private String address;
	private String phone;
    private List<String> userSkills;	
    private List<UserExperience> userExperience ;    
	private List<UserLinks> userLinks ;
	private List<UserEduaction> userEducation;
	private String CvTemplate ;
}
