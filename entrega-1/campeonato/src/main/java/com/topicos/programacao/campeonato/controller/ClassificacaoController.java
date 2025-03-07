package com.topicos.programacao.campeonato.controller;

import com.topicos.programacao.campeonato.domain.Classificacao;
import com.topicos.programacao.campeonato.service.ClassificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/classificacao")
public class ClassificacaoController {

    @Autowired
    private ClassificacaoService service;

    @GetMapping("/ordem/{campeonato}")
    public ResponseEntity getClassificaoTeams(@PathVariable("campeonato") Long campeonatoId) {
        return ResponseEntity.ok(service.classificacaoTeamsByCampeonato(campeonatoId));
    }

    @PostMapping
    public ResponseEntity createCampeonato(@RequestBody Classificacao classificacao) {
        return ResponseEntity.status(201).body(service.createClassificacao(classificacao));
    }

    @PutMapping("/change-position-team/{campeonatoId}/{teamId}/{classification}")
    public ResponseEntity changePositionTeam(@PathVariable("campeonatoId") Long campeonatoId,
                                             @PathVariable("teamId") Long teamId,
                                             @PathVariable("classification") Integer classification) {
        service.changeTeamClassificationInChampionship(campeonatoId, teamId, classification);
        return ResponseEntity.ok().build();
    }
}
