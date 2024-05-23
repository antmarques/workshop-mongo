package com.workshop.api.resources;

import com.workshop.api.dto.PostDto;
import com.workshop.api.entities.PostEntity;
import com.workshop.api.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "post")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping(value = "/all")
    public ResponseEntity<List<PostDto>> findAll() {
        List<PostEntity> listEntity = service.findAll();
        List<PostDto> listDto = listEntity.stream().map(PostDto::new).toList();
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostDto> findById(@PathVariable String id) {
        PostEntity entity = service.findById(id);
        return ResponseEntity.ok().body(new PostDto(entity));
    }
}
