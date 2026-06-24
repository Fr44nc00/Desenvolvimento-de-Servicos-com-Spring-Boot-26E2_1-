package com.francombbs.dss_at.controllers;

import com.francombbs.dss_at.entities.Medico;
import com.francombbs.dss_at.services.MedicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @PostMapping
    public ResponseEntity<Medico> cadastrar(@RequestBody Medico medico) {
        return ResponseEntity.ok(medicoService.salvar(medico));
    }

    @GetMapping
    public List<Medico> listarTodos() {
        return medicoService.listarTodos();
    }

    @GetMapping("/ranking-consultas")
    public List<Medico> listarPorQuantidadeConsultas() {
        return medicoService.listarPorQuantidadeConsultas();
    }
}
