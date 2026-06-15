package com.francombbs.tp3_dss.service;

import com.francombbs.tp3_dss.model.entity.Aluno;
import com.francombbs.tp3_dss.repository.AlunoRepository;
import com.francombbs.tp3_dss.repository.AlunoTreinoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final AlunoTreinoRepository alunoTreinoRepository;

    public AlunoService(AlunoRepository alunoRepository, AlunoTreinoRepository alunoTreinoRepository) {
        this.alunoRepository = alunoRepository;
        this.alunoTreinoRepository = alunoTreinoRepository;
    }

    public Aluno salvar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public List<Aluno> listarAtivos() {
        return alunoRepository.findByAtivoTrue();
    }

    public List<String> rankingAlunos() {
        return alunoTreinoRepository.findRankingAlunos()
                .stream()
                .map(obj -> {
                    Aluno aluno = (Aluno) obj[0];
                    Long total = (Long) obj[1];
                    return aluno.getNome() + " - " + total + " treinos concluídos";
                })
                .collect(Collectors.toList());
    }
}
