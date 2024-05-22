package com.workshop.api.config;

import com.workshop.api.dto.AuthorDto;
import com.workshop.api.entities.PostEntity;
import com.workshop.api.entities.UserEntity;
import com.workshop.api.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.workshop.api.repositories.UserRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

@Configuration
@Profile("dev")
public class DevConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        UserEntity user1 = new UserEntity(null, "Antonio Carlos", "antonio@gmail.com");
        UserEntity user2 = new UserEntity(null, "Cassio Lauerentino", "kssio@gmail.com");
        UserEntity user3 = new UserEntity(null, "Thiago Marques", "thiago@gmail.com");
        UserEntity user4 = new UserEntity(null, "Janette Carmozina", "janette@gmail.com");
        userRepository.saveAll(Arrays.asList(user1, user2, user3, user4));

        postRepository.deleteAll();
        PostEntity post1 = new PostEntity(null, new Date(), "Partiu SP","Vou viajar para São Paulo. Abraços", new AuthorDto(user3));
        PostEntity post2 = new PostEntity(null, new Date(), "Enfim 2.1 anos","Ficando mais velho e desempregado mesmo formado", new AuthorDto(user1));
        postRepository.saveAll(Arrays.asList(post1, post2));

        user1.getPosts().add(post2);
        user3.getPosts().add(post1);
        userRepository.saveAll(Arrays.asList(user1, user3));
    }
}
