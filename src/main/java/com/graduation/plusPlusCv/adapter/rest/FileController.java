package com.graduation.plusPlusCv.adapter.rest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import com.graduation.plusPlusCv.adapter.repo.FileRepoMongo;
import com.graduation.plusPlusCv.models.File;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/file")
public class FileController {
    private final FileRepoMongo fileRepository;
    private final MongoTemplate mongoTemplate;

    public FileController(FileRepoMongo fileRepository, MongoTemplate mongoTemplate) {
        this.fileRepository = fileRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile multipart , @RequestParam("exe") String exe) {
        File image = new File();
        try {
            image.setId(UUID.randomUUID().toString());
            image.setReferenceId(image.getId()+exe);
            image.setDocType("pictures");
            image.setFile(new Binary(BsonBinarySubType.BINARY, multipart.getBytes()));
            fileRepository.insert(image);
            // System.out.println(image);
            byte[] bytes = retrieveFile( image.getId(),exe);
            
        } catch (Exception e) {
            e.printStackTrace();
            return "failure";
        }
        return image.getId()+exe;
    }

    //@PostMapping("/images/public/id/{id}")
    //@RequestParam("id")
    public byte[] retrieveFile( String id,String exe) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        File demoDocument = mongoTemplate.findOne(query, File.class);
        Binary document = demoDocument.getFile();
        if (document != null) {
            FileOutputStream fileOuputStream = null;
            try {
//                fileOuputStream = new FileOutputStream("./files/users-upload/"+demoDocument.getId() + exe);
//                fileOuputStream.write(document.getData());
                fileOuputStream = new FileOutputStream("./src/main/resources/static/images/"+ demoDocument.getId() + exe);
                fileOuputStream.write(document.getData());
                fileOuputStream = new FileOutputStream("./target/classes/static/images/"+ demoDocument.getId() + exe);
                fileOuputStream.write(document.getData());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (fileOuputStream != null) {
                    try {
                        fileOuputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        return demoDocument.getFile().getData();
                    }
                }
            }
        }
        return demoDocument.getFile().getData();
    }

}
