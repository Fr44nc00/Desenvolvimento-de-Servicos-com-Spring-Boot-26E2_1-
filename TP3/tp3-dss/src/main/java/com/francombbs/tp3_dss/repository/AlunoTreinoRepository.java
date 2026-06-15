package com.francombbs.tp3_dss.repository;

import com.francombbs.tp3_dss.model.entity.AlunoTreino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlunoTreinoRepository extends JpaRepository<AlunoTreino, Long> {

    @Query("SELECT at.aluno AS aluno, COUNT(at) AS total " +
            "FROM AlunoTreino at " +
            "WHERE at.concluido = true " +
            "GROUP BY at.aluno " +
            "ORDER BY COUNT(at) DESC")
    List<Object[]> findRankingAlunos();
}