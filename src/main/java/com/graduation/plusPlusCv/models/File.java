package com.graduation.plusPlusCv.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class File {
    @Id
    @Field
    private String id;

    @Field
    private String referenceId;

    @Field
    private String docType;

    @Field
    private Binary file;
}
