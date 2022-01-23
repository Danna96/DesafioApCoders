package com.apcoder.apcoder.service;

import com.apcoder.apcoder.exceptions.InexistenteException;
import com.apcoder.apcoder.model.Inquilino;
import com.apcoder.apcoder.repositoy.InquilinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InquilinoService {

    private final InquilinoRepository inquilinoRepository;

    @Autowired
    public InquilinoService(InquilinoRepository inquilinoRepository) {
        this.inquilinoRepository = inquilinoRepository;
    }

    public void saveInquilino(Inquilino inquilino) {
        inquilinoRepository.save(inquilino);
    }

    public Inquilino getInquilino(Long id) {
        return inquilinoRepository.findById(id).orElseThrow(() -> new InexistenteException("Inquilino " + id + " inexistente."));
    }

    public List<Inquilino> findAllInquilinos() {
        return inquilinoRepository.findAll();
    }
}
