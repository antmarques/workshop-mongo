package com.workshop.api.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Document("user")
@Data
public class UserEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String name;

    private String email;

    @DBRef(lazy = true)
    private List<PostEntity> posts = new ArrayList<>();

    public UserEntity() {
    }

    public UserEntity(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
