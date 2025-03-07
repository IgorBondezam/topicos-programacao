package com.topicos.programacao.campeonato.repository;

import com.topicos.programacao.campeonato.domain.Classificacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassificacaoRepository extends JpaRepository<Classificacao, Long> {

    List<Classificacao> findClassificacaoByCampeonato_Id(Long campeonatoId);

    @Query("select count(c.id) > 0 from Classificacao c " +
            " where c.campeonato.id = :campeonatoId " +
            " and c.time.id = :teamId " +
            " and c.posicao = :posicao")
    Boolean isPosicaoJaSelecionadaParaAlguemNoCampeonato(@Param("campeonatoId") Long campeonatoId,
                                                         @Param("teamId") Long teamId,
                                                         @Param("posicao") Integer posicao);
}
