package com.topicos.programacao.campeonato.domain.DTO;

public class ClassificacaoTeamDTO {
    private Long idCampeonato;
    private Long idTeam;
    private String nomeTeam;

    private Integer posicao;

    public ClassificacaoTeamDTO(Long idCampeonato, Long idTeam, String nomeTeam, Integer posicao) {
        this.idCampeonato = idCampeonato;
        this.idTeam = idTeam;
        this.nomeTeam = nomeTeam;
        this.posicao = posicao;
    }

    public ClassificacaoTeamDTO() {
    }

    public Long getIdCampeonato() {
        return idCampeonato;
    }

    public void setIdCampeonato(Long idCampeonato) {
        this.idCampeonato = idCampeonato;
    }

    public Long getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(Long idTeam) {
        this.idTeam = idTeam;
    }

    public String getNomeTeam() {
        return nomeTeam;
    }

    public void setNomeTeam(String nomeTeam) {
        this.nomeTeam = nomeTeam;
    }

    public Integer getPosicao() {
        return posicao;
    }

    public void setPosicao(Integer posicao) {
        this.posicao = posicao;
    }
}
