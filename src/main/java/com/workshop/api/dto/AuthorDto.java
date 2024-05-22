package com.workshop.api.dto;

import com.workshop.api.entities.UserEntity;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


@Data
public class AuthorDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    public AuthorDto() {
    }

    public AuthorDto(UserEntity entity) {
        id = entity.getId();
        name = entity.getName();
    }
}
