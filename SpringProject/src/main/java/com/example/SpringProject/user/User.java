package com.example.SpringProject.user;

import com.example.SpringProject.restaurante.Restaurante;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;
import java.util.Set;

@Entity
@Table
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequece",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private String nome;
    private String endereco;
    private String senha;
    private Boolean admin;
    private String email;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "reserva",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "restaurante_id"))
    private Collection<Restaurante> restaurante;
    public User() {}

    public User(Long id, String nome, String endereco, String senha, Boolean admin, String email) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.senha = senha;
        this.admin = admin;
        this.email = email;
    }

    public User(String nome, String endereco, String senha, Boolean admin, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.senha = senha;
        this.admin = admin;
        this.email = email;
    }

    public Collection<Restaurante> getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Collection<Restaurante> restaurante) {
        this.restaurante = restaurante;
    }

    public void addRestaurante(Restaurante restaurante) {
        this.restaurante.add(restaurante);
    }

    public void removerRestaurante(Restaurante restaurante) {
        this.restaurante.remove(restaurante);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean isAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", senha='" + senha + '\'' +
                ", admin=" + admin +
                ", email='" + email + '\'' +
                '}';
    }
}
