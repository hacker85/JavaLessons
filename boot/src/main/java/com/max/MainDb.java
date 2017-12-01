package com.max;


import com.max.entities.User;
import com.max.interfaces.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainDb {
    @Autowired
    UserRepository userRepository;
    public static void main(String[] args) {
        SpringApplication.run(MainDb.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            userRepository.save(new User("Max"));
        };
    }
}
