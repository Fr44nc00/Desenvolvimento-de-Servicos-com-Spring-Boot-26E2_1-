package com.francombbs.dss_at.services;

import com.francombbs.dss_at.entities.Paciente;
import com.francombbs.dss_at.repositories.PacienteRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PacienteServiceTest {

    private final PacienteRepository pacienteRepository = Mockito.mock(PacienteRepository.class);
    private final PacienteService pacienteService = new PacienteService(pacienteRepository);

    @Test
    void deveCadastrarPaciente() {
        Paciente paciente = new Paciente();
        paciente.setNome("João Silva");
        paciente.setCpf("12345678901");

        when(pacienteRepository.save(paciente)).thenReturn(paciente);

        Paciente salvo = pacienteService.salvar(paciente);

        assertNotNull(salvo);
        assertEquals("João Silva", salvo.getNome());
        verify(pacienteRepository, times(1)).save(paciente);
    }

    @Test
    void deveBuscarPacientePorId() {
        Paciente paciente = new Paciente();
        paciente.setId(1L);
        paciente.setNome("Maria Oliveira");

        when(pacienteRepository.findById(1L)).thenReturn(Optional.of(paciente));

        Optional<Paciente> encontrado = pacienteService.buscarPorId(1L);

        assertTrue(encontrado.isPresent());
        assertEquals("Maria Oliveira", encontrado.get().getNome());
    }

    @Test
    void deveExcluirPaciente() {
        Long id = 1L;

        doNothing().when(pacienteRepository).deleteById(id);

        pacienteService.remover(id);

        verify(pacienteRepository, times(1)).deleteById(id);
    }

    @Test
    void deveRetornarVazioQuandoPacienteNaoExiste() {
        when(pacienteRepository.findById(99L)).thenReturn(Optional.empty());

        Optional<Paciente> resultado = pacienteService.buscarPorId(99L);

        assertFalse(resultado.isPresent());
    }
}
