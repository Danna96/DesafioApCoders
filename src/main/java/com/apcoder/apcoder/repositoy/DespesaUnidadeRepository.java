package com.apcoder.apcoder.repositoy;

import com.apcoder.apcoder.model.DespesaUnidade;
import com.apcoder.apcoder.model.Unidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DespesaUnidadeRepository extends JpaRepository<DespesaUnidade, Long> {

    List<DespesaUnidade> findAllByUnidade(Unidade unidade);

    @Query("SELECT du FROM DespesaUnidade du WHERE du.statusPagamento = false and du.vencimentoFatura < now()")
    List<DespesaUnidade> findAllDespesasByFaturaVencida();

}
