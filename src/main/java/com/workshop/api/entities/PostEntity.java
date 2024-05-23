package com.workshop.api.entities;

import com.workshop.api.dto.AuthorDto;
import com.workshop.api.dto.CommentDto;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serial;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "post")
@Data
public class PostEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private Date date;

    @Transient
    private String dateFormat;

    private String title;

    private String body;

    private AuthorDto author;

    private List<CommentDto> comments = new ArrayList<>();

    public PostEntity() {
    }

    public PostEntity(String id, Date date, String title, String body, AuthorDto author) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }

    public String getDateFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat = sdf.format(date);
        return dateFormat;
    }
}
