package com.example.SpringProject.restaurante;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RestauranteService {

    private final RestauranteRepository restauranteRepository;
    @Autowired
    public RestauranteService(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    public List<Restaurante> getCliente() {
        return restauranteRepository.findAll();
    }

    public void addNewCliente(Restaurante restaurante) {
        Optional<Restaurante> clienteOptional = restauranteRepository.findClienteBYEmail(restaurante.getEmail());
        if (clienteOptional.isPresent()) {
            throw new IllegalStateException("email takes");
        }
        restauranteRepository.save(restaurante);
    }

    public void deleteCliente(Long id) {
        boolean exists = restauranteRepository.existsById(id);
        if(!exists) {
             throw new IllegalStateException("studened" + id + "doesnt exist");
        }
        restauranteRepository.deleteById(id);
    }

    @Transactional
    public void updateCliente (Long restauranteId, String bairro, String localizacao, String atendimentoPresencial, Integer capacidade, String telefone, String email) {
        Restaurante restaurante = restauranteRepository.findById(restauranteId)
                .orElseThrow(() -> new IllegalStateException(
                        "resta ..." + restauranteId));

        if (bairro != null && bairro.length() > 0 && !Objects.equals(restaurante.getBairro(), bairro)) {
            restaurante.setBairro(bairro);
        }
        if (localizacao != null && localizacao.length() > 0 && !Objects.equals(restaurante.getLocalizacao(), localizacao)) {
            restaurante.setLocalizacao(localizacao);
        }
        if (atendimentoPresencial != null && atendimentoPresencial.length() > 0 && !Objects.equals(restaurante.getAtendimentoPresencial(), atendimentoPresencial)) {
            restaurante.setAtendimentoPresencial(atendimentoPresencial);
        }
        if (capacidade != null && !Objects.equals(restaurante.getCapacidade(), capacidade)) {
            restaurante.setCapacidade(capacidade);
        }
        if (telefone != null && telefone.length() > 0 && !Objects.equals(restaurante.getTelefone(), telefone)) {
            restaurante.setTelefone(telefone);
        }
        if (email != null && email.length() > 0 && !Objects.equals(restaurante.getEmail(), email)) {
            restaurante.setEmail(email);
        }


    }
}
