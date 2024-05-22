package com.workshop.api.resources;

import com.workshop.api.dto.UserDto;
import com.workshop.api.entities.PostEntity;
import com.workshop.api.entities.UserEntity;
import com.workshop.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping(value = "/all")
    public ResponseEntity<List<UserDto>> findAll() {
        List<UserEntity> listEntity = service.findAll();
        List<UserDto> listDto = listEntity.stream().map(UserDto::new).toList();
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable String id) {
        UserEntity entity = service.findById(id);
        return ResponseEntity.ok().body(new UserDto(entity));
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<List<PostEntity>> findPosts(@PathVariable String id) {
        UserEntity entity = service.findById(id);
        return ResponseEntity.ok().body(entity.getPosts().reversed());
    }

    @PostMapping("/insert")
    public ResponseEntity<Void> insert(@RequestBody UserDto dto) {
        UserEntity entity = service.fromDto(dto);
        entity = service.insert(entity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UserDto dto) {
        UserEntity entity = service.fromDto(dto);
        entity.setId(id);
        entity = service.upadte(entity);
        return ResponseEntity.noContent().build();
    }
}
