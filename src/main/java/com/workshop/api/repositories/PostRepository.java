package com.workshop.api.repositories;

import com.workshop.api.entities.PostEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<PostEntity, String> {

    List<PostEntity> findByTitleContainingIgnoreCase(String text);

    @Query("{body: { $regex: ?0, $options: 'i' } }")
    List<PostEntity> findByDesc(String text);
}
