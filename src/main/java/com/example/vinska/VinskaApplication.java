package com.example.vinska;

import com.example.vinska.domain.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VinskaApplication {

    public static void main(String[] args) {
        SpringApplication.run(VinskaApplication.class, args);
    }
    @Bean
    public CommandLineRunner vinyls(VinylRepository vrepository, GenreRepository grepository, UserRepository userRepository){
        return (args) -> {
            grepository.save(new Genre("Rock"));
            grepository.save(new Genre("Pop"));
            grepository.save(new Genre("R&B"));
            grepository.save(new Genre("Rap/Hip-Hop"));
            grepository.save(new Genre("Jazz"));
            grepository.save(new Genre("Country"));
            grepository.save(new Genre("Reggae"));
            grepository.save(new Genre("Latin"));


            User user1 = new User("user","$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
            User user2 = new User("admin","$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");

            userRepository.save(user1);
            userRepository.save(user2);

        };



    }
}
