package com.workshop.api.services;

import com.workshop.api.dto.UserDto;
import com.workshop.api.repositories.UserRepository;
import com.workshop.api.entities.UserEntity;
import com.workshop.api.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
        return user.orElseThrow(() -> new ObjectNotFoundException(id + " Not founded"));
    }

    public UserEntity insert(UserEntity user) {
        return userRepository.insert(user);
    }

    public void deleteById(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    public UserEntity fromDto(UserDto dto) {
        return new UserEntity(dto.getId(), dto.getName(), dto.getEmail());
    }
}
