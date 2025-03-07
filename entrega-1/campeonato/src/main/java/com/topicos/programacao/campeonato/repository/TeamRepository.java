package com.topicos.programacao.campeonato.repository;

import com.topicos.programacao.campeonato.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
}
