package com.workshop.api.dto;

import com.workshop.api.entities.PostEntity;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class PostDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;

    private Date date;

    private String dateFormat;

    private String title;

    private String body;

    private AuthorDto author;

    private List<CommentDto> comments = new ArrayList<>();

    public PostDto() {
    }

    public PostDto(PostEntity postEntity) {
        id = postEntity.getId();
        date = postEntity.getDate();
        title = postEntity.getTitle();
        dateFormat = postEntity.getDateFormat();
        body = postEntity.getBody();
        author = postEntity.getAuthor();
        comments = postEntity.getComments();
    }
}
