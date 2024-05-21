package com.workshop.api.dto;

import com.workshop.api.entities.UserEntity;
import lombok.Data;

@Data
public class UserDto {

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
