package com.graduation.plusPlusCv.service.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateNewApplicationsDTO {
	private String userId;
	private String jobPostId;
}
