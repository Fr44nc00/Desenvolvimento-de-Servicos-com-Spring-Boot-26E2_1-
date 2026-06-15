package com.francombbs.tp3_dss.controller;

import com.francombbs.tp3_dss.service.TokenService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tokens")
public class TokenController {

    private final TokenService tokenService;

    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/{alunoId}")
    public String gerarToken(@PathVariable Long alunoId) {
        return tokenService.gerarToken(alunoId);
    }

    @GetMapping("/{token}")
    public boolean validarToken(@PathVariable String token) {
        return tokenService.validarToken(token);
    }
}
