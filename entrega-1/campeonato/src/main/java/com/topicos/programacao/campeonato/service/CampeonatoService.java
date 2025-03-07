package com.topicos.programacao.campeonato.service;

import com.topicos.programacao.campeonato.domain.Campeonato;
import com.topicos.programacao.campeonato.repository.CampeonatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;

@Service
public class CampeonatoService {

    @Autowired
    private CampeonatoRepository repository;

    public List<Campeonato> findAll() {
        return repository.findAll();
    }

    public Campeonato findById(Long id) {
        return repository.findById(id).orElseThrow(InvalidParameterException::new);
    }

    public Campeonato createCampeonato(Campeonato campeonato) {
        return repository.save(campeonato);
    }
}
