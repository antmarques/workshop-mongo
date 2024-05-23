package com.workshop.api.config;

import com.workshop.api.dto.AuthorDto;
import com.workshop.api.dto.CommentDto;
import com.workshop.api.entities.PostEntity;
import com.workshop.api.entities.UserEntity;
import com.workshop.api.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.workshop.api.repositories.UserRepository;
import java.util.Arrays;
import java.util.Date;

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
        PostEntity post1 = new PostEntity(null, new Date(),"Partiu SP", "Vou viajar para São Paulo. Abraços", new AuthorDto(user3));
        PostEntity post2 = new PostEntity(null, new Date(), "Enfim 2.1 anos", "Ficando mais velho e desempregado mesmo formado", new AuthorDto(user1));
        PostEntity post3 = new PostEntity(null, new Date(), "Comprei meu primeiro video game","Meu sonho desde criança era comprar um vídeo game sozinho!",
                new AuthorDto(user1));
        CommentDto comment1 = new CommentDto("Boa viajem mano", new Date(), new AuthorDto(user1));
        CommentDto comment2 = new CommentDto("Parabéns pela sua conquista!", new Date(), new AuthorDto(user4));
        CommentDto comment3 = new CommentDto("Agora consegue ganhar de mim no F1!", new Date(), new AuthorDto(user3));
        CommentDto comment4 = new CommentDto("Dias melhores viram, FÉ!", new Date(), new AuthorDto(user2));
        post1.getComments().add(comment1);
        post2.getComments().add(comment4);
        post3.getComments().addAll(Arrays.asList(comment2, comment3));
        postRepository.saveAll(Arrays.asList(post1, post2, post3));

        user1.getPosts().addAll(Arrays.asList(post2, post3));
        user3.getPosts().add(post1);
        userRepository.saveAll(Arrays.asList(user1, user3));
    }
}
