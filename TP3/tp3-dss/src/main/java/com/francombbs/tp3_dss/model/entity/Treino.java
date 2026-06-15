package com.francombbs.tp3_dss.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Treino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String focoPrincipal;

    @ManyToOne
    @JoinColumn(name = "instrutor_id")
    private Instrutor instrutor;
}