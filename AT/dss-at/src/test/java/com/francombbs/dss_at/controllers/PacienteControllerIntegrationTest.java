package com.francombbs.dss_at.controllers;

import tools.jackson.databind.ObjectMapper;
import com.francombbs.dss_at.entities.Paciente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class PacienteControllerIntegrationTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    void testeCadastrarPaciente() throws Exception {
        Paciente paciente = new Paciente();
        paciente.setNome("Teste Paciente");
        paciente.setCpf("11122233344");
        paciente.setTelefone("21999999999");

        mockMvc.perform(post("/pacientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(paciente)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Teste Paciente"))
                .andExpect(jsonPath("$.cpf").value("11122233344"));
    }

    @Test
    void testeBuscarPacientePorId() throws Exception {
        Paciente paciente = new Paciente();
        paciente.setNome("Paciente Busca");
        paciente.setCpf("55566677788");
        paciente.setTelefone("21988888888");

        String response = mockMvc.perform(post("/pacientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(paciente)))
                .andReturn().getResponse().getContentAsString();

        Paciente salvo = objectMapper.readValue(response, Paciente.class);

        mockMvc.perform(get("/pacientes/" + salvo.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Paciente Busca"))
                .andExpect(jsonPath("$.cpf").value("55566677788"));
    }

    @Test
    void testeListarPacientes() throws Exception {
        mockMvc.perform(get("/pacientes"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void testeExcluirPaciente() throws Exception {
        Paciente paciente = new Paciente();
        paciente.setNome("Paciente Excluir");
        paciente.setCpf("99988877766");
        paciente.setTelefone("21977777777");

        String response = mockMvc.perform(post("/pacientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(paciente)))
                .andReturn().getResponse().getContentAsString();

        Paciente salvo = objectMapper.readValue(response, Paciente.class);

        mockMvc.perform(delete("/pacientes/" + salvo.getId()))
                .andExpect(status().isNoContent());

        mockMvc.perform(get("/pacientes/" + salvo.getId()))
                .andExpect(status().isNotFound());
    }
}
