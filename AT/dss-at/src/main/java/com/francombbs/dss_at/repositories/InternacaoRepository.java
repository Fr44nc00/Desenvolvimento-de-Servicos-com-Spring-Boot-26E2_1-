package com.francombbs.dss_at.repositories;

import com.francombbs.dss_at.entities.Internacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternacaoRepository extends JpaRepository<Internacao, Long> {
}
