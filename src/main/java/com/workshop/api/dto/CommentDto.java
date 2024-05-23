package com.workshop.api.dto;

import lombok.Data;
import org.springframework.data.annotation.Transient;
import java.io.Serial;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class CommentDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String text;

    private Date date;

    @Transient
    private String dateFormat;

    private AuthorDto author;

    public CommentDto() {
    }

    public CommentDto(String text, Date date, AuthorDto author) {
        this.text = text;
        this.date = date;
        this.author = author;
    }

    public String getDateFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat = sdf.format(date);
        return dateFormat;
    }
}
