package com.topicos.programacao.campeonato.controller;

import com.topicos.programacao.campeonato.domain.Campeonato;
import com.topicos.programacao.campeonato.service.CampeonatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/campeonato")
public class CampeonatoController {

    @Autowired
    private CampeonatoService service;

    @GetMapping
    public ResponseEntity findAll() {
        try {
            return ResponseEntity.ok(service.findAll());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity createCampeonato(@RequestBody Campeonato campeonato) {
        return ResponseEntity.status(201).body(service.createCampeonato(campeonato));
    }
}
