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
public class ContactMessage {
	@Id
	private String id;
	private String name ;
	private String email;
	private String message;
}
