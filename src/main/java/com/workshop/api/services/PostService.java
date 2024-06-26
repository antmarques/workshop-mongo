package com.workshop.api.services;

import com.workshop.api.dto.PostDto;
import com.workshop.api.entities.PostEntity;
import com.workshop.api.repositories.PostRepository;
import com.workshop.api.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
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

    public List<PostEntity> findByTitle(String text) {
        return postRepository.findByTitleContainingIgnoreCase(text);
    }

    public List<PostEntity> findByDesc(String text) {
        return postRepository.findByDesc(text);
    }

    public List<PostEntity> advancedSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        List<PostEntity> retorno = postRepository.advancedSearch(text, minDate, maxDate);
        if (retorno.isEmpty()) {
            throw new ObjectNotFoundException("Post não encontrado!");
        }
        return retorno;
    }

    public PostEntity fromDto(PostDto dto) {
        return new PostEntity(dto.getId(), dto.getDate(), dto.getTitle(), dto.getBody(), dto.getAuthor());
    }
}
