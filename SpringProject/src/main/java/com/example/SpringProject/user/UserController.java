package com.example.SpringProject.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getCliente(){
        return userService.getCliente();
    }

    @GetMapping (path = "{userId}")
    public User getUser(
            @PathVariable("userId") Long userId){
        return userService.getUser(userId);
    }

    @GetMapping (path = "reserva/{userId}")
    public List getUserReservas(
            @PathVariable("userId") Long userId){
        return userService.getUserReservas(userId);
    }

    @PostMapping
    public void registerNewCliente(@RequestBody User user){
        userService.addNewCliente(user);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteCliente(@PathVariable ("userId") Long id){
        userService.deleteCliente(id);
    }

    @PutMapping (path = "{userId}")
    public void updateCliente (
            @PathVariable("userId") Long userId,
            @RequestParam(required = true) String nome,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String endereco,
            @RequestParam(required = false) String senha,
            @RequestParam(required = false) Boolean admin
    ) {
        userService.updateCliente(userId, nome, email, endereco, senha, admin);
    }

    @PutMapping (path = "reserva/{userId}")
    public void criarReserva (
            @PathVariable("userId") Long userId,
            @RequestParam(required = true) Long restauranteId
    ) {
        System.out.println(restauranteId);
        System.out.println(userId);
        System.out.println("valueeeeeeeeee");
        System.out.println("valueeeeeeeeee");
        System.out.println("valueeeeeeeeee");
        System.out.println("valueeeeeeeeee");
        System.out.println("valueeeeeeeeee");
        System.out.println("valueeeeeeeeee");

        userService.criarReserva(userId, restauranteId);
    }

    @DeleteMapping (path = "reserva")
    public void removerReserva (
            @RequestParam(required = true) Long userId,
            @RequestParam(required = true) Long restauranteId
    ) {
        userService.removerReserva(userId, restauranteId);
    }
}
