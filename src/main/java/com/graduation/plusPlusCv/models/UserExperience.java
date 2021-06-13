package com.graduation.plusPlusCv.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserExperience {
	private String id;
	private String startYear;
	private String endYear;
	private String description;


}
