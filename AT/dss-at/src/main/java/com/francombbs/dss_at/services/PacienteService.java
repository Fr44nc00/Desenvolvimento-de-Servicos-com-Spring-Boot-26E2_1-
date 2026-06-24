package com.francombbs.dss_at.services;

import com.francombbs.dss_at.entities.Paciente;
import com.francombbs.dss_at.repositories.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente salvar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Optional<Paciente> buscarPorId(Long id) {
        return pacienteRepository.findById(id);
    }

    public List<Paciente> listarTodos() {
        return pacienteRepository.findAll();
    }

    public void remover(Long id) {
        pacienteRepository.deleteById(id);
    }
}
