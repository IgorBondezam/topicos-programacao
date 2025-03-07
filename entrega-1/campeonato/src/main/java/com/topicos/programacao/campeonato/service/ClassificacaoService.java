package com.topicos.programacao.campeonato.service;

import com.topicos.programacao.campeonato.domain.Campeonato;
import com.topicos.programacao.campeonato.domain.Classificacao;
import com.topicos.programacao.campeonato.domain.DTO.ClassificacaoTeamDTO;
import com.topicos.programacao.campeonato.domain.Team;
import com.topicos.programacao.campeonato.repository.ClassificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Service
public class ClassificacaoService {

    @Autowired
    private ClassificacaoRepository repository;

    @Autowired
    private CampeonatoService campeonatoService;

    @Autowired
    private TeamService teamService;

    public void changeTeamClassificationInChampionship(Long campeonatoId, Long teamId, Integer classification) {
        Campeonato campeonato = campeonatoService.findById(campeonatoId);

        if(classification > campeonato.getQuantidadeTimes()) {
            throw new InvalidParameterException();
        }

        List<Classificacao> classificacoes = repository.findClassificacaoByCampeonato_Id(campeonatoId);

        Classificacao classificacaoTime = classificacoes.stream().filter(c -> c.getTime().getId().equals(teamId))
                .findFirst().orElseThrow(InvalidParameterException::new);

        for (Classificacao classificacao: classificacoes) {
            if(classificacao.getPosicao().equals(classificacaoTime.getPosicao())) {
                classificacao.setPosicao(classification);
                continue;
            }
            if(classificacao.getPosicao() >= classification && classificacao.getPosicao() < classificacaoTime.getPosicao()
                    && !Objects.equals(classificacao.getId(), classificacaoTime.getId())) {
                classificacao.setPosicao(classificacao.getPosicao()+1);
                continue;
            }
            if(classificacao.getPosicao() > classificacaoTime.getPosicao()
                    && !Objects.equals(classificacao.getId(), classificacaoTime.getId())) {
                classificacao.setPosicao(classificacao.getPosicao()-1);
            }
        }

        repository.saveAll(classificacoes);

    }

    public Classificacao createClassificacao(Classificacao classificacao) {
        classificacao.setTime(teamService.findById(classificacao.getTime().getId()));
        classificacao.setCampeonato(campeonatoService.findById(classificacao.getCampeonato().getId()));

        if(repository.isPosicaoJaSelecionadaParaAlguemNoCampeonato(classificacao.getCampeonato().getId(),
                classificacao.getTime().getId(),
                classificacao.getPosicao())) {
            throw new InvalidParameterException();
        }

        return repository.save(classificacao);
    }

    public List<ClassificacaoTeamDTO> classificacaoTeamsByCampeonato(Long campeonatoId) {
        List<Classificacao> classificacao = repository.findClassificacaoByCampeonato_Id(campeonatoId);

        List<ClassificacaoTeamDTO> classificacaoTeam = new ArrayList<>();
        classificacao.forEach(c -> {
            classificacaoTeam.add(new ClassificacaoTeamDTO(c.getCampeonato().getId(),
                    c.getTime().getId(), c.getTime().getNome(), c.getPosicao()));
        });

        classificacaoTeam.sort(Comparator.comparingInt(ClassificacaoTeamDTO::getPosicao));
        return classificacaoTeam;
    }
}
