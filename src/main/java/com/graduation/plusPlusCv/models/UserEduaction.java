package com.graduation.plusPlusCv.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEduaction {
	private String id;
	private String startYear;
	private String endYear;
	private String description;

}
