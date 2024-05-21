package com.workshop.api.services;

import com.workshop.api.repositories.UserRepository;
import com.workshop.api.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public UserEntity findById(String id) {
        Optional<UserEntity> user = userRepository.findById(id);
        return user.get();
    }

}
