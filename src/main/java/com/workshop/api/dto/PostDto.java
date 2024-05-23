package com.workshop.api.dto;

import com.workshop.api.entities.PostEntity;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class PostDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private String id;

    private Date date;

    private String dateFormat;

    private String title;

    private String body;

    private AuthorDto author;


    public PostDto() {
    }

    public PostDto(PostEntity postEntity) {
        id = postEntity.getId();
        date = postEntity.getDate();
        title = postEntity.getTitle();
        dateFormat = sdf.format(date);
        body = postEntity.getBody();
        author = postEntity.getAuthor();
    }
}
