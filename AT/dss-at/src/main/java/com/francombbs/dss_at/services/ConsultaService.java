package com.francombbs.dss_at.services;

import com.francombbs.dss_at.entities.Consulta;
import com.francombbs.dss_at.repositories.ConsultaRepository;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {

    private final ConsultaRepository consultaRepository;

    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    public Consulta salvar(Consulta consulta) {
        return consultaRepository.save(consulta);
    }
}
