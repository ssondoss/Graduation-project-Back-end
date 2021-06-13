package com.graduation.plusPlusCv.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.graduation.plusPlusCv.models.User.UserBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Applications {
	@Id
	private String id;
	private User user;
	private JobPost jobPost;
    private LocalDateTime appliedDate;
    private Boolean viewedByPublisher;
}
