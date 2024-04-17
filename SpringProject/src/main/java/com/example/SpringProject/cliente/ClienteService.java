package com.example.SpringProject.cliente;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getCliente() {
        return clienteRepository.findAll();
    }

    public void addNewCliente(Cliente cliente) {

        Optional<Cliente> clienteOptional = clienteRepository.findClienteBYEmail(cliente.getEmail());
        if (clienteOptional.isPresent()) {
            throw new IllegalStateException("email takes");
        }
        clienteRepository.save(cliente);
    }

    public void deleteCliente(Long id) {
        boolean exists = clienteRepository.existsById(id);
        if(!exists) {
             throw new IllegalStateException("studened" + id + "doesnt exist");
        }
        clienteRepository.deleteById(id);
    }

    public void updateCliente (Long clienteId, Cliente cliente) {
        cliente.setId(clienteId);
        clienteRepository.save(cliente);
    }

//    @Transactional
//    public void updateCliente (Long clienteId, String name, String email) {
//        Cliente cliente = clienteRepository.findById(clienteId)
//                .orElseThrow(() -> new IllegalStateException(
//                        "cliente ..." + clienteId));
//
//        if (name != null && name.length() > 0 && !Objects.equals(cliente.getNome(), name)) {
//            cliente.setNome(name);
//        }
//
//        if (email != null && email.length() > 0 && !Objects.equals(cliente.getEmail(), email)) {
//            Optional<Cliente> clienteOptional = clienteRepository.findClienteBYEmail(email);
//            if (clienteOptional.isPresent()) {
//                throw new IllegalStateException("email taken");
//            }
//            cliente.setEmail(email);
//        }
//    }
}
