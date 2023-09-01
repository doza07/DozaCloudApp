package com.doza.authserver;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DozaCloudAuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DozaCloudAuthServerApplication.class, args);
    }

    @Bean
    public ApplicationRunner dataLoader(
            UserRepository repo, PasswordEncoder encoder) {
        return args -> {
            repo.save(
                    new User("test1", encoder.encode("password"), "ROLE_ADMIN"));
            repo.save(
                    new User("test2", encoder.encode("password"), "ROLE_ADMIN"));
        };
    }
}
