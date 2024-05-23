package com.workshop.api.dto;

import com.workshop.api.entities.UserEntity;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;

@Data
public class UserDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private String email;

    public UserDto() {
    }

    public UserDto(UserEntity user) {
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
    }
}
