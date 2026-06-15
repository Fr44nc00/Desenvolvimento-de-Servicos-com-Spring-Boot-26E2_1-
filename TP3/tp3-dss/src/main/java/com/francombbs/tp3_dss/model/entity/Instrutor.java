package com.francombbs.tp3_dss.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Instrutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cref; // registro profissional

    @OneToMany(mappedBy = "instrutor")
    private List<Treino> treinos;
}
