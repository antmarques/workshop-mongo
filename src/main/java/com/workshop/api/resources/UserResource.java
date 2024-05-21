package com.workshop.api.resources;

import com.workshop.api.dto.UserDto;
import com.workshop.api.entities.UserEntity;
import com.workshop.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping(value = "/all")
    public ResponseEntity<List<UserDto>> findAll() {
        List<UserEntity> list = service.findAll();
        List<UserDto> listDto = list.stream().map(UserDto::new).toList();
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> findById(@PathVariable("id") String id) {
        UserEntity user = service.findById(id);
        return ResponseEntity.ok().body(user);
    }

}
