package com.francombbs.tp3_dss.model.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private LocalDate dataNascimento;

    private Boolean ativo;

    @ManyToOne
    @JoinColumn(name = "plano_id")
    private Plano plano;
}
