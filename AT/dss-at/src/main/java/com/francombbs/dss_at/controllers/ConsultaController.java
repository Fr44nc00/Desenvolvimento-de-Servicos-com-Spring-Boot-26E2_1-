package com.francombbs.dss_at.controllers;

import com.francombbs.dss_at.entities.Consulta;
import com.francombbs.dss_at.services.ConsultaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @PostMapping
    public ResponseEntity<Consulta> cadastrar(@RequestBody Consulta consulta) {
        return ResponseEntity.ok(consultaService.salvar(consulta));
    }
}
