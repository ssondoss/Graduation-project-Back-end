package com.graduation.plusPlusCv.models;
import java.time.LocalDateTime;
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
public class JobPost {
	@Id
	private String id;
	private UserDTO user ;
	private String jobRole;
	private String companyName;
	private String country ;
	private Boolean status ;
	private String jobLocation;
	private String jobDescription;
	private List<String> skills ;
	private List<String> qualifications;
	private String employementType ;
	private String experienceLevel ;
    private long dateAndTime;

}
