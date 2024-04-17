package com.example.SpringProject.restaurante;

import com.example.SpringProject.user.User;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;
import java.util.Set;

@Entity
@Table
public class Restaurante {
    @Id
    @SequenceGenerator(
            name = "restaurante_sequece",
            sequenceName = "restaurante_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "restaurante_sequence"
    )
    private Long id;
    private String bairro;
    private String localizacao;
    private String atendimentoPresencial;
    private Integer capacidade;
    private String telefone;
    private String email;

//    @ManyToMany(mappedBy = "restaurante")
//    private Collection<User> user;

    public Restaurante() {}

    public Restaurante(String bairro, String localizacao, String atendimentoPresencial, Integer capacidade, String telefone, String email) {
        this.bairro = bairro;
        this.localizacao = localizacao;
        this.atendimentoPresencial = atendimentoPresencial;
        this.capacidade = capacidade;
        this.telefone = telefone;
        this.email = email;
    }

    public Restaurante(Long id, String bairro, String localizacao, String atendimentoPresencial, Integer capacidade, String telefone, String email) {
        this.id = id;
        this.bairro = bairro;
        this.localizacao = localizacao;
        this.atendimentoPresencial = atendimentoPresencial;
        this.capacidade = capacidade;
        this.telefone = telefone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getAtendimentoPresencial() {
        return atendimentoPresencial;
    }

    public void setAtendimentoPresencial(String atendimentoPresencial) {
        this.atendimentoPresencial = atendimentoPresencial;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Restaurante{" +
                "id=" + id +
                ", bairro='" + bairro + '\'' +
                ", localizacao='" + localizacao + '\'' +
                ", atendimentoPresencial='" + atendimentoPresencial + '\'' +
                ", capacidade='" + capacidade + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
