package com.workshop.api.repositories;

import com.workshop.api.entities.PostEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<PostEntity, String> {
    List<PostEntity> findByTitleContainingIgnoreCase(String text);
}
