package com.example.SpringProject.user;

import com.example.SpringProject.restaurante.Restaurante;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;
import java.util.List;


@Configuration
public class UserConfig {


    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
            User jr = new User(1L,
                    "jr",
                    "Rua Os Dezoito do Forte, 454",
                    "senha",
                    false,
                    "email1@Gmail"
            );
            User admin = new User(2L,
                    "admin",
                    "Rua Os Dezoito do Forte, 454",
                    "senha",
                    true,
                    "email2@Gmail"
            );
            Restaurante novo = new Restaurante(
                    "portao",
                    "Rua Os Dezoito do Forte, 454",
                    "Das 11h30 às 22h",
                    220,
                    "41-91612205",
                    "restaurante1@Gmail"
            );
//            List<Restaurante> restaurantes = Collections.singletonList(novo);
//            jr.setRestaurante(restaurantes);
            repository.saveAll(
                    List.of(jr, admin)
            );
        };
    }
}
