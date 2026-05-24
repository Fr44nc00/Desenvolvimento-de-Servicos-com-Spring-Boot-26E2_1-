package com.francombbs.tp2_dss.controllers;

import com.francombbs.tp2_dss.dtos.PassagemRequestDTO;
import com.francombbs.tp2_dss.dtos.PassagemResponseDTO;
import com.francombbs.tp2_dss.services.PassagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/passagens")
public class PassagemController {

    private final PassagemService passagemService;

    @Autowired
    public PassagemController(PassagemService passagemService) {
        this.passagemService = passagemService;
    }

    @GetMapping
    public ResponseEntity<?> listarPassagens() {
        return ResponseEntity.ok(passagemService.listarPassagens());
    }

    @PostMapping
    public ResponseEntity<PassagemResponseDTO> criarPassagem(@RequestBody PassagemRequestDTO dto) {
        PassagemResponseDTO nova = passagemService.criarPassagem(dto);
        return ResponseEntity.status(201).body(nova);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PassagemResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(passagemService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PassagemResponseDTO> atualizarPassagem(@PathVariable Long id,
                                                                 @RequestBody PassagemRequestDTO dto) {
        PassagemResponseDTO atualizada = passagemService.atualizarPassagem(id, dto);
        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPassagem(@PathVariable Long id) {
        passagemService.deletarPassagem(id);
        return ResponseEntity.noContent().build(); // HTTP 204
    }
    @GetMapping("/busca")
    public ResponseEntity<List<PassagemResponseDTO>> buscarPorDestino(@RequestParam String destino) {
        List<PassagemResponseDTO> resultado = passagemService.buscarPorDestino(destino);
        return ResponseEntity.ok(resultado);
    }
}
