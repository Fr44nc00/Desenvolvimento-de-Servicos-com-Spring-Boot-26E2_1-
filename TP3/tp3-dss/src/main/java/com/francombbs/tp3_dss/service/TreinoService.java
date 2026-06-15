package com.francombbs.tp3_dss.service;

import com.francombbs.tp3_dss.model.entity.Treino;
import com.francombbs.tp3_dss.repository.TreinoRepository;
import org.springframework.stereotype.Service;

@Service
public class TreinoService {

    private final TreinoRepository treinoRepository;

    public TreinoService(TreinoRepository treinoRepository) {
        this.treinoRepository = treinoRepository;
    }

    public Treino salvar(Treino treino) {
        return treinoRepository.save(treino);
    }
}
