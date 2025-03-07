package com.topicos.programacao.campeonato.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Campeonato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private Integer quantidadeTimes;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "campeonato")
    @JsonManagedReference("campeonato-classificacao")
    private List<Classificacao> classificacaos;

    public Campeonato(Long id, LocalDate dataInicial, LocalDate dataFinal, Integer quantidadeTimes, List<Classificacao> classificacaos) {
        this.id = id;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.quantidadeTimes = quantidadeTimes;
        this.classificacaos = classificacaos;
    }

    public Campeonato(Long id, LocalDate dataInicial, LocalDate dataFinal, Integer quantidadeTimes) {
        this.id = id;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.quantidadeTimes = quantidadeTimes;
    }

    public Campeonato() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Integer getQuantidadeTimes() {
        return quantidadeTimes;
    }

    public void setQuantidadeTimes(Integer quantidadeTimes) {
        this.quantidadeTimes = quantidadeTimes;
    }

    public List<Classificacao> getClassificacaos() {
        return classificacaos;
    }

    public void setClassificacaos(List<Classificacao> classificacaos) {
        this.classificacaos = classificacaos;
    }
}
