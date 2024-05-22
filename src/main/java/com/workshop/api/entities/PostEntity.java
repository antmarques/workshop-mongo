package com.workshop.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.workshop.api.dto.AuthorDto;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Document(collection = "post")
@Data
public class PostEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private Date date;

    private String dateFormat;

    private String title;

    private String body;

    private AuthorDto author;

    public PostEntity() {
    }

    public PostEntity(String id, Date date, String dateFormat,String title, String body, AuthorDto author) {
        this.id = id;
        this.date = date;
        this.dateFormat = dateFormat;
        this.title = title;
        this.body = body;
        this.author = author;
    }
}
