package com.francombbs.dss_at.services;

import com.francombbs.dss_at.entities.Medico;
import com.francombbs.dss_at.repositories.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public Medico salvar(Medico medico) {
        return medicoRepository.save(medico);
    }

    public List<Medico> listarTodos() {
        return medicoRepository.findAll();
    }

    public List<Medico> listarPorQuantidadeConsultas() {
        return medicoRepository.findMedicosOrderByConsultasDesc();
    }
}
