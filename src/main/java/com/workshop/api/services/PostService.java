package com.workshop.api.services;

import com.workshop.api.dto.PostDto;
import com.workshop.api.entities.PostEntity;
import com.workshop.api.repositories.PostRepository;
import com.workshop.api.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<PostEntity> findAll() {
        return postRepository.findAll();
    }

    public PostEntity findById(String id) {
        Optional<PostEntity> entity = postRepository.findById(id);
        return entity.orElseThrow(() -> new ObjectNotFoundException(id + " Not founded"));
    }

    public PostEntity fromDto(PostDto dto) {
        return new PostEntity(dto.getId(), dto.getDate(), dto.getTitle(), dto.getBody(), dto.getAuthor());
    }
}
