package com.francombbs.tp3_dss.controller;

import com.francombbs.tp3_dss.model.entity.Treino;
import com.francombbs.tp3_dss.service.TreinoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/treinos")
public class TreinoController {

    private final TreinoService treinoService;

    public TreinoController(TreinoService treinoService) {
        this.treinoService = treinoService;
    }

    @PostMapping
    public Treino cadastrarTreino(@RequestBody Treino treino) {
        return treinoService.salvar(treino);
    }
}
