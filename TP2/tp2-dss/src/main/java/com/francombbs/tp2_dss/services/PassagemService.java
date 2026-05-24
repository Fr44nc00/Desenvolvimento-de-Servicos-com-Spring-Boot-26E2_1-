package com.francombbs.tp2_dss.services;

import com.francombbs.tp2_dss.dtos.PassagemMapper;
import com.francombbs.tp2_dss.dtos.PassagemRequestDTO;
import com.francombbs.tp2_dss.dtos.PassagemResponseDTO;
import com.francombbs.tp2_dss.models.Passagem;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PassagemService {

    private List<Passagem> passagens = new ArrayList<>();
    private Long idCounter = 1L;

    public PassagemService() {
        passagens.add(new Passagem(idCounter++, "Mateus", 12,
                "Rio de Janeiro", "São Paulo", LocalDate.of(2026, 6, 10), "Confirmada"));
        passagens.add(new Passagem(idCounter++, "Fernanda", 8,
                "São Paulo", "Belo Horizonte", LocalDate.of(2026, 6, 15), "Pendente"));
        passagens.add(new Passagem(idCounter++, "Carlos", 20,
                "Belo Horizonte", "Salvador", LocalDate.of(2026, 6, 20), "Cancelada"));
    }

    public PassagemResponseDTO criarPassagem(PassagemRequestDTO dto) {
        boolean assentoOcupado = passagens.stream()
                .anyMatch(p -> p.getAssento().equals(dto.getAssento()));

        if (assentoOcupado) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Assento já ocupado!");
        }

        Passagem nova = PassagemMapper.toModel(dto, idCounter++);
        passagens.add(nova);
        return PassagemMapper.toResponseDTO(nova);
    }

    public List<PassagemResponseDTO> listarPassagens() {
        return passagens.stream()
                .map(PassagemMapper::toResponseDTO)
                .toList();
    }

    public PassagemResponseDTO buscarPorId(Long id) {
        return passagens.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .map(PassagemMapper::toResponseDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Passagem não encontrada"));
    }

    public PassagemResponseDTO atualizarPassagem(Long id, PassagemRequestDTO dto) {
        Passagem passagem = passagens.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Passagem não encontrada"));

        passagem.setPassageiro(dto.getPassageiro());
        passagem.setAssento(dto.getAssento());
        passagem.setOrigem(dto.getOrigem());
        passagem.setDestino(dto.getDestino());
        passagem.setData(dto.getData());
        passagem.setStatus(dto.getStatus());

        return PassagemMapper.toResponseDTO(passagem);
    }

    public void deletarPassagem(Long id) {
        boolean removida = passagens.removeIf(p -> p.getId().equals(id));

        if (!removida) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Passagem não encontrada");
        }
    }

    public List<PassagemResponseDTO> buscarPorDestino(String destino) {
        List<PassagemResponseDTO> resultado = passagens.stream()
                .filter(p -> p.getDestino().equalsIgnoreCase(destino))
                .map(PassagemMapper::toResponseDTO)
                .toList();

        if (resultado.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhuma passagem encontrada para o destino informado");
        }

        return resultado;
    }

}
