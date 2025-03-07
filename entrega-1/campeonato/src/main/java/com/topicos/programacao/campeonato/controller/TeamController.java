package com.topicos.programacao.campeonato.controller;

import com.topicos.programacao.campeonato.domain.Team;
import com.topicos.programacao.campeonato.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService service;

    @GetMapping
    public ResponseEntity findAll() {
        try {
            return ResponseEntity.ok(service.findAll());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity createTeam(@RequestBody Team team) {
        return ResponseEntity.status(201).body(service.createTeam(team));
    }
}
