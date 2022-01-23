package com.apcoder.apcoder.controller;

import com.apcoder.apcoder.model.Inquilino;
import com.apcoder.apcoder.service.InquilinoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Controlador de inquilinos.")
@RequestMapping(path = "api/inquilino")
@RestController
public class InquilinoController {

    private final InquilinoService inquilinoService;

    @Autowired
    public InquilinoController(InquilinoService inquilinoService) {
        this.inquilinoService = inquilinoService;
    }

    @Operation(summary = "Adicionar novo inquilino.")
    @PostMapping
    public void saveInquilino (@Valid @RequestBody Inquilino inquilino) {
        inquilinoService.saveInquilino(inquilino);
    }

    @Operation(summary = "Buscar inquilino pelo id.")
    @GetMapping(path = "{id}")
    public Inquilino getInquilino(Long id) {
        return inquilinoService.getInquilino(id);
    }

    @Operation(summary = "Buscar todos os inquilinos.")
    @GetMapping
    public List<Inquilino> findAllInquilinos() {
        return inquilinoService.findAllInquilinos();
    }

}
