package com.example.SpringProject.restaurante;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


@Configuration
public class RestauranteConfig {


    @Bean
    CommandLineRunner commandLineRunner3(RestauranteRepository repository){
        return args -> {
            Restaurante jr = new Restaurante(3L,
                    "portao",
                    "Rua Os Dezoito do Forte, 454",
                    "Das 11h30 às 22h",
                    220,
                    "41-91612205",
                    "restaurante1@Gmail"
            );
            Restaurante novo = new Restaurante(3L,
                    "portao",
                    "Rua Os Dezoito do Forte, 454",
                    "Das 11h30 às 22h",
                    220,
                    "41-91612205",
                    "restaurante1@Gmail"
            );
            repository.saveAll(
                    List.of(jr, novo)
            );
        };
    }
}
