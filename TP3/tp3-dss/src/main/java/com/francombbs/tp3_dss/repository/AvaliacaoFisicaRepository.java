package com.francombbs.tp3_dss.repository;

import com.francombbs.tp3_dss.model.document.AvaliacaoFisica;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AvaliacaoFisicaRepository extends MongoRepository<AvaliacaoFisica, String> {
    List<AvaliacaoFisica> findByAlunoId(Long alunoId);
}
