package com.francombbs.dss_at.config;

import com.francombbs.dss_at.entities.Medico;
import com.francombbs.dss_at.entities.Paciente;
import com.francombbs.dss_at.repositories.MedicoRepository;
import com.francombbs.dss_at.repositories.PacienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(MedicoRepository medicoRepository, PacienteRepository pacienteRepository) {
        return args -> {
            if (medicoRepository.count() == 0) {
                Medico cardiologista = new Medico();
                cardiologista.setNome("Cardiologista");
                cardiologista.setCrm("CRM001");
                cardiologista.setEspecialidade("Cardiologia");

                Medico ortopedista = new Medico();
                ortopedista.setNome("Ortopedista");
                ortopedista.setCrm("CRM002");
                ortopedista.setEspecialidade("Ortopedia");

                medicoRepository.save(cardiologista);
                medicoRepository.save(ortopedista);
            }

            if (pacienteRepository.count() == 0) {
                Paciente joao = new Paciente();
                joao.setNome("João Silva");
                joao.setCpf("12345678901");
                joao.setTelefone("21999999999");

                Paciente maria = new Paciente();
                maria.setNome("Maria Oliveira");
                maria.setCpf("98765432100");
                maria.setTelefone("21988888888");

                pacienteRepository.save(joao);
                pacienteRepository.save(maria);
            }
        };
    }
}
