package com.example.SpringProject;
import com.example.SpringProject.restaurante.Restaurante;
import com.example.SpringProject.user.User;
import com.example.SpringProject.user.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class SpringProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringProjectApplication.class, args);
//		ApplicationContext context = SpringApplication.run(SpringProjectApplication.class, args);
//		UserRepository userRepository = context.getBean(UserRepository.class);

//		userRepository.save(createUserObject1());
	}
//		private static User createUserObject1() {
//			User admin = new User(3L,
//					"admin",
//					"Rua Os Dezoito do Forte, 454",
//					"senha",
//					true,
//					"email2@Gmail"
//			);
//			Restaurante novo = new Restaurante(3L,
//					"portao",
//					"Rua Os Dezoito do Forte, 454",
//					"Das 11h30 às 22h",
//					220,
//					"41-91612205",
//					"restaurante1@Gmail"
//			);
//			List<Restaurante> restaurantes = Collections.singletonList(novo);
//			admin.setRestaurante(restaurantes);
//			return admin;
//		}
	}
