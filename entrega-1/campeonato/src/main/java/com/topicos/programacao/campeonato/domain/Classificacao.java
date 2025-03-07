package com.topicos.programacao.campeonato.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Classificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JsonBackReference("campeonato-classificacao")
    private Campeonato campeonato;

    @ManyToOne
    @JsonBackReference("time-classificacao")
    private Team time;

    private Integer posicao;

    public Classificacao(Long id, Campeonato campeonato, Team time, Integer posicao) {
        this.id = id;
        this.campeonato = campeonato;
        this.time = time;
        this.posicao = posicao;
    }

    public Classificacao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    public Team getTime() {
        return time;
    }

    public void setTime(Team time) {
        this.time = time;
    }

    public Integer getPosicao() {
        return posicao;
    }

    public void setPosicao(Integer posicao) {
        this.posicao = posicao;
    }
}
