package com.graduation.plusPlusCv.models;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.graduation.plusPlusCv.models.User.UserBuilder;
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
public class JobNotification {
@Id
String id;
UserDTO user;
Boolean viewedByUser;
JobPost jobPost;
 LocalDateTime dateAndTime;

}
