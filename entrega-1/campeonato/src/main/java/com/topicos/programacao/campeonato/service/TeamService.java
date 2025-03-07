package com.topicos.programacao.campeonato.service;

import com.topicos.programacao.campeonato.domain.Team;
import com.topicos.programacao.campeonato.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository repository;

    public List<Team> findAll() {
        return repository.findAll();
    }

    public Team findById(Long id) {
        return repository.findById(id).orElseThrow(InvalidParameterException::new);
    }

    public Team createTeam(Team team) {
        return repository.save(team);
    }
}
