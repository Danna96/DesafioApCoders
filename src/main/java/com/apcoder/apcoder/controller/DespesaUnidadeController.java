package com.apcoder.apcoder.controller;

import com.apcoder.apcoder.model.DespesaUnidade;
import com.apcoder.apcoder.service.DespesaUnidadeService;
import com.apcoder.apcoder.service.UnidadeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Controlador de despesas das unidades.")
@RequestMapping(path = "api/despesaUnidade")
@RestController
public class DespesaUnidadeController {

    private final DespesaUnidadeService despesaUnidadeService;
    private final UnidadeService unidadeService;

    @Autowired
    public DespesaUnidadeController(DespesaUnidadeService despesaUnidadeService, UnidadeService unidadeService) {
        this.despesaUnidadeService = despesaUnidadeService;
        this.unidadeService = unidadeService;
    }

    @Operation(summary = "Adicionar despesa a uma unidade.")
    @PostMapping
    public void saveDespesaUnidade(@Valid @RequestBody DespesaUnidade despesaUnidade) {
        unidadeService.getUnidade(despesaUnidade.getUnidade().getId());
        despesaUnidadeService.saveDespesaUnidade(despesaUnidade);
    }

    @Operation(summary = "Editar despesas das unidades.")
    @PutMapping(path = "{id}")
    public void editarDespesaUnidade(@RequestParam("id") Long id, @RequestBody DespesaUnidade despesaUnidade) {
        if (despesaUnidade.getUnidade() != null) {
            unidadeService.getUnidade(despesaUnidade.getUnidade().getId());
        }
        despesaUnidadeService.editarDespesaUnidade(id, despesaUnidade);
    }

    @Operation(summary = "Buscar todas as despesas.")
    @GetMapping
    public List<DespesaUnidade> findAllDespesaUnidades() {
        return despesaUnidadeService.getAllDespesaUnidades();
    }

    @Operation(summary = "Filtrar despesas pela unidade.")
    @GetMapping(path = "/filtroUnidade/{id}")
    public List<DespesaUnidade> findAllDespesaByUnidade(@RequestParam("id") Long id) {
        return despesaUnidadeService.getAllDespesasByUnidade(unidadeService.getUnidade(id));
    }

    @Operation(summary = "Filtrar despesas pela fatura vencida.")
    @GetMapping(path = "/filtroFaturaVencida")
    public List<DespesaUnidade> getAllDespesasByFaturaVencida() {
        return despesaUnidadeService.getAllDespesasByFaturaVencida();
    }
}
