package com.francombbs.tp2_dss.dtos;

import com.francombbs.tp2_dss.models.Passagem;

public class PassagemMapper {

    public static Passagem toModel(PassagemRequestDTO dto, Long id) {
        return new Passagem(
                id,
                dto.getPassageiro(),
                dto.getAssento(),
                dto.getOrigem(),
                dto.getDestino(),
                dto.getData(),
                dto.getStatus()
        );
    }

    public static PassagemResponseDTO toResponseDTO(Passagem passagem) {
        return new PassagemResponseDTO(
                passagem.getId(),
                passagem.getPassageiro(),
                passagem.getAssento(),
                passagem.getOrigem(),
                passagem.getDestino(),
                passagem.getData(),
                passagem.getStatus()
        );
    }
}
