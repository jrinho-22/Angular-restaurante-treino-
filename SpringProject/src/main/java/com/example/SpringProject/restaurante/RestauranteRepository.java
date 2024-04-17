package com.example.SpringProject.restaurante;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestauranteRepository
        extends JpaRepository<Restaurante, Long> {
    @Query("SELECT s FROM Restaurante s WHERE s.email = ?1")
    Optional<Restaurante> findClienteBYEmail(String email);
}
