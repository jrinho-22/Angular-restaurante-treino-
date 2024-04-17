package com.example.SpringProject.cliente;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Cliente {
    @Id
    @SequenceGenerator(
            name = "cliente_sequece",
            sequenceName = "cliente_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cliente_sequence"
    )
    private Long id;
    private String nome;

    public Integer getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private String email;
    private LocalDate dob;
    @Transient
    private Integer age;

    public Cliente() {}

    public Cliente(Long id, String nome, String email, LocalDate dob) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dob = dob;
    }

    public Cliente(String nome, String email, LocalDate dob) {
        this.nome = nome;
        this.email = email;
        this.dob = dob;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                '}';
    }
}
