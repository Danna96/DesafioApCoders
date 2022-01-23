package com.apcoder.apcoder.controller;

import com.apcoder.apcoder.model.Unidade;
import com.apcoder.apcoder.service.UnidadeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Controlador de unidades.")
@RequestMapping(path = "api/unidade")
@RestController
public class UnidadeController {

    public UnidadeService unidadeService;

    @Autowired
    public UnidadeController(UnidadeService unidadeService) {
        this.unidadeService = unidadeService;
    }

    @Operation(summary = "Adicionar nova unidade.")
    @PostMapping
    public void saveUnidade(@Valid @RequestBody Unidade unidade) {
        unidadeService.saveUnidade(unidade);
    }

    @Operation(summary = "Buscar unidade pelo id.")
    @GetMapping(path = "{id}")
    public Unidade getUnidade(@PathVariable("id") Long id) {
        return unidadeService.getUnidade(id);
    }

    @Operation(summary = "Buscar todos as unidades.")
    @GetMapping
    public List<Unidade> findAllUnidades() {
        return unidadeService.findAllUnidades();
    }

}
