package com.workshop.api.repositories;

import com.workshop.api.entities.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {

    @Query(value = "{'_id': ?0}")
    Optional<UserEntity> findById(String id);
}
