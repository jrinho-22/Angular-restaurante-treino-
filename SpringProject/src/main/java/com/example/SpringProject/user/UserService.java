package com.example.SpringProject.user;

import com.example.SpringProject.restaurante.Restaurante;
import com.example.SpringProject.restaurante.RestauranteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RestauranteRepository restauranteRepository;
    @Autowired
    public UserService(UserRepository userRepository, RestauranteRepository restauranteRepository) {
        this.userRepository = userRepository;
        this.restauranteRepository = restauranteRepository;
    }

    public List<User> getCliente() {
        return userRepository.findAll();
    }

    public void addNewCliente(User user) {

        Optional<User> clienteOptional = userRepository.findClienteBYEmail(user.getEmail());
        if (clienteOptional.isPresent()) {
            throw new IllegalStateException("email takes");
        }
        userRepository.save(user);
    }

    public void deleteCliente(Long id) {
        boolean exists = userRepository.existsById(id);
        if(!exists) {
             throw new IllegalStateException("studened" + id + "doesnt exist");
        }
        userRepository.deleteById(id);
    }

    @Transactional
    public void updateCliente (Long userId, String name, String email, String endereco, String senha, Boolean admin) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException(
                        "user ..." + userId));
        Restaurante restaurante = restauranteRepository.findById(1L)
                .orElseThrow(() -> new IllegalStateException(
                        "user ..." + userId));

        if (name != null && name.length() > 0 && !Objects.equals(user.getNome(), name)) {
            user.setNome(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(user.getEmail(), email)) {
            user.setEmail(email);
        }

        if (endereco != null && endereco.length() > 0 && !Objects.equals(user.getEndereco(), endereco)) {
            user.setEndereco(endereco);
        }

        if (senha != null && senha.length() > 0 && !Objects.equals(user.getSenha(), senha)) {
            user.setSenha(senha);
        }

        if (admin != null && !Objects.equals(user.isAdmin(), admin)) {
            user.setAdmin(admin);
        }

    }

    @Transactional
    public void criarReserva(Long userId, Long restauranteId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException(
                        "user ..." + userId));
        Restaurante restaurante = restauranteRepository.findById(restauranteId)
                .orElseThrow(() -> new IllegalStateException(
                        "user ..." + userId));
        System.out.println(user.getRestaurante());
        if (restaurante != null) {
           //List<Restaurante> restaurantes = Collections.singletonList(restaurante);
            user.addRestaurante(restaurante);
        }
    }
    @Transactional
    public void removerReserva(Long userId, Long restauranteId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException(
                        "user ..." + userId));
        Restaurante restaurante = restauranteRepository.findById(restauranteId)
                .orElseThrow(() -> new IllegalStateException(
                        "user ..." + userId));
        System.out.println(user.getRestaurante());
        if (restaurante != null) {
            //List<Restaurante> restaurantes = Collections.singletonList(restaurante);
            user.removerRestaurante(restaurante);
        }
    }

    public User getUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException(
                        "user ..." + userId));
        return user;
    }

    public List getUserReservas(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException(
                        "user ..." + userId));
        List<Long> ids = new ArrayList<>();
        for (Restaurante restaurante : user.getRestaurante()){
            ids.add(restaurante.getId());
        }
        return ids;
    }
}
