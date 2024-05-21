package com.workshop.api.config;

import com.workshop.api.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.workshop.api.repositories.UserRepository;

import java.util.Arrays;

@Configuration
@Profile("dev")
public class DevConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        UserEntity user1 = new UserEntity(null, "Antonio Carlos", "antonio@gmail.com");
        UserEntity user2 = new UserEntity(null, "Cassio Lauerentino", "kssio@gmail.com");
        UserEntity user3 = new UserEntity(null, "Thiago Marques", "thiago@gmail.com");
        UserEntity user4 = new UserEntity(null, "Janette Carmozina", "janette@gmail.com");
        userRepository.saveAll(Arrays.asList(user1, user2, user3, user4));
    }
}
