package com.apcoder.apcoder.service;

import com.apcoder.apcoder.exceptions.InexistenteException;
import com.apcoder.apcoder.model.DespesaUnidade;
import com.apcoder.apcoder.model.Unidade;
import com.apcoder.apcoder.repositoy.DespesaUnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class DespesaUnidadeService {

    private final DespesaUnidadeRepository despesaUnidadeRepository;

    @Autowired
    public DespesaUnidadeService(DespesaUnidadeRepository despesaUnidadeRepository) {
        this.despesaUnidadeRepository = despesaUnidadeRepository;
    }

    public void saveDespesaUnidade(DespesaUnidade despesaUnidade) {
        despesaUnidadeRepository.save(despesaUnidade);
    }

    public DespesaUnidade getDespesaUnidade(Long id) {
        return despesaUnidadeRepository.findById(id).orElseThrow(() -> new InexistenteException("Despesa " + id + " inexistente."));
    }

    private <T> void editarCampoNotNull(T valor, Consumer<T> consumer) {
        Optional.ofNullable(valor).ifPresent(consumer);
    }

    public void editarDespesaUnidade(Long id, DespesaUnidade despesaUnidade) {
        DespesaUnidade despesaUnidadeToUpdate = getDespesaUnidade(id);

        this.editarCampoNotNull(despesaUnidade.getUnidade(),despesaUnidadeToUpdate::setUnidade);
        this.editarCampoNotNull(despesaUnidade.getDescricao(), despesaUnidadeToUpdate::setDescricao);
        this.editarCampoNotNull(despesaUnidade.getTipoDespesa(), despesaUnidadeToUpdate::setTipoDespesa);
        this.editarCampoNotNull(despesaUnidade.getValor(), despesaUnidadeToUpdate::setValor);
        this.editarCampoNotNull(despesaUnidade.getVencimentoFatura(), despesaUnidadeToUpdate::setVencimentoFatura);
        this.editarCampoNotNull(despesaUnidade.getStatusPagamento(), despesaUnidadeToUpdate::setStatusPagamento);
        despesaUnidadeRepository.save(despesaUnidadeToUpdate);
    }

    public List<DespesaUnidade> getAllDespesaUnidades() {
        return despesaUnidadeRepository.findAll();
    }

    public List<DespesaUnidade> getAllDespesasByUnidade(Unidade unidade) {
        return despesaUnidadeRepository.findAllByUnidade(unidade);
    }

    public List<DespesaUnidade> getAllDespesasByFaturaVencida() {
        return despesaUnidadeRepository.findAllDespesasByFaturaVencida();
    }
}
