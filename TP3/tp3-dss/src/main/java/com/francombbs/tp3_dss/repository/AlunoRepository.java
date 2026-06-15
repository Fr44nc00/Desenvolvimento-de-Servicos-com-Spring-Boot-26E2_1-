package com.francombbs.tp3_dss.repository;

import com.francombbs.tp3_dss.model.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    List<Aluno> findByAtivoTrue();
}
