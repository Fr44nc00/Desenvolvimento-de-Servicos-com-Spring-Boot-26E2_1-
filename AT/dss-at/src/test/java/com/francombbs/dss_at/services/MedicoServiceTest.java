package com.francombbs.dss_at.services;

import com.francombbs.dss_at.entities.Medico;
import com.francombbs.dss_at.repositories.MedicoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MedicoServiceTest {

    private final MedicoRepository medicoRepository = Mockito.mock(MedicoRepository.class);
    private final MedicoService medicoService = new MedicoService(medicoRepository);

    @Test
    void deveCadastrarMedico() {
        Medico medico = new Medico();
        medico.setNome("Cardiologista");
        medico.setCrm("CRM001");
        medico.setEspecialidade("Cardiologia");

        when(medicoRepository.save(medico)).thenReturn(medico);

        Medico salvo = medicoService.salvar(medico);

        assertNotNull(salvo);
        assertEquals("Cardiologista", salvo.getNome());
        verify(medicoRepository, times(1)).save(medico);
    }
}
