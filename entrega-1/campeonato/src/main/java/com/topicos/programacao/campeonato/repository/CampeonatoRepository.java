package com.topicos.programacao.campeonato.repository;

import com.topicos.programacao.campeonato.domain.Campeonato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampeonatoRepository extends JpaRepository<Campeonato, Long> {
}
