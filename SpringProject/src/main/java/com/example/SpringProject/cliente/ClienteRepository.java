package com.example.SpringProject.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository
        extends JpaRepository<Cliente, Long> {
    @Query("SELECT s FROM Cliente s WHERE s.email = ?1")
    Optional<Cliente> findClienteBYEmail(String email);
}
