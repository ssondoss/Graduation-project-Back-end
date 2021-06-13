package com.graduation.plusPlusCv.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLinks {
	private String id ;
	private String link ;
	private String icon ;
}
