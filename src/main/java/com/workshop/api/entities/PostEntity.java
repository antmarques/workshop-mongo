package com.workshop.api.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "post")
@Data
public class PostEntity {

    @Id
    private String id;

    private Date date;

    private String title;

    private String body;

    private UserEntity author;

    public PostEntity() {
    }

    public PostEntity(String id, Date date, String title, String body, UserEntity author) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }
}
