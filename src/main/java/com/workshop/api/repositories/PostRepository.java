package com.workshop.api.repositories;

import com.workshop.api.entities.PostEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<PostEntity, String> {

    List<PostEntity> findByTitleContainingIgnoreCase(String text);

    @Query("{body: { $regex: ?0, $options: 'i' }}")
    List<PostEntity> findByDesc(String text);

    @Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<PostEntity> advancedSearch(String text, Date minDate, Date maxDate);
}
