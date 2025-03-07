package com.topicos.programacao.campeonato.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "time")
    @JsonManagedReference("time-classificacao")
    private List<Classificacao> classificacaos;

    public Team(Long id, String nome, List<Classificacao> classificacaos) {
        this.id = id;
        this.nome = nome;
        this.classificacaos = classificacaos;
    }

    public Team(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Team() {
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

    public List<Classificacao> getClassificacaos() {
        return classificacaos;
    }

    public void setClassificacaos(List<Classificacao> classificacaos) {
        this.classificacaos = classificacaos;
    }
}
