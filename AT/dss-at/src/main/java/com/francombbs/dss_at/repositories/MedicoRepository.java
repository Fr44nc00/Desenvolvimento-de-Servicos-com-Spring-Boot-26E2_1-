package com.francombbs.dss_at.repositories;

import com.francombbs.dss_at.entities.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    @Query("SELECT m FROM Medico m LEFT JOIN m.consultas c GROUP BY m ORDER BY COUNT(c) DESC")
    List<Medico> findMedicosOrderByConsultasDesc();
}
