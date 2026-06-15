package com.francombbs.tp3_dss.controller;

import com.francombbs.tp3_dss.model.entity.Aluno;
import com.francombbs.tp3_dss.service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public Aluno cadastrarAluno(@RequestBody Aluno aluno) {
        return alunoService.salvar(aluno);
    }

    @GetMapping("/ativos")
    public List<Aluno> listarAlunosAtivos() {
        return alunoService.listarAtivos();
    }

    @GetMapping("/ranking")
    public List<String> rankingAlunos() {
        return alunoService.rankingAlunos();
    }
}
