package com.francombbs.tp3_dss.controller;

import com.francombbs.tp3_dss.model.document.AvaliacaoFisica;
import com.francombbs.tp3_dss.repository.AvaliacaoFisicaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    private final AvaliacaoFisicaRepository repository;

    public AvaliacaoFisicaController(AvaliacaoFisicaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public AvaliacaoFisica cadastrar(@RequestBody AvaliacaoFisica avaliacao) {
        return repository.save(avaliacao);
    }

    @GetMapping("/{alunoId}")
    public List<AvaliacaoFisica> listarPorAluno(@PathVariable Long alunoId) {
        return repository.findByAlunoId(alunoId);
    }
}

