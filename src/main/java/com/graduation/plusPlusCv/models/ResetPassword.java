package com.graduation.plusPlusCv.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResetPassword {

	@Id
	private String  id;
	private String userId;
	private String code;
	private Boolean isUsed;
}
