package com.example.SpringProject.cliente;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


@Configuration
public class ClienteConfig {


    @Bean
    CommandLineRunner commandLineRunner2(ClienteRepository repository){
        return args -> {
            Cliente jr = new Cliente(1L,
                    "jr",
                    "jr@Gmail",
                    LocalDate.of(2000, Month.MAY, 22)
            );
            repository.saveAll(
                    List.of(jr)
            );
        };
    }
}
