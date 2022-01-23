package com.apcoder.apcoder.service;

import com.apcoder.apcoder.exceptions.InexistenteException;
import com.apcoder.apcoder.model.Unidade;
import com.apcoder.apcoder.repositoy.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadeService {

    private final UnidadeRepository unidadeRepository;

    @Autowired
    public UnidadeService(UnidadeRepository unidadeRepository) {
        this.unidadeRepository = unidadeRepository;
    }

    public void saveUnidade(Unidade unidade) {
        unidadeRepository.save(unidade);
    }

    public Unidade getUnidade(Long id) {
        return unidadeRepository.findById(id).orElseThrow(() -> new InexistenteException("Unidade " + id + " inexistente."));
    }

    public List<Unidade> findAllUnidades() {
        return unidadeRepository.findAll();
    }
}
