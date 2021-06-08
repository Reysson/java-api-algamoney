package com.reysson.algamoney.repository.query;

import com.reysson.algamoney.model.Lancamento;
import com.reysson.algamoney.repository.filter.LancamentoFilter;
import com.reysson.algamoney.repository.projecao.LancamentoResumo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface LancamentoRepositoryQuery {
     
    public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);
    public Page<LancamentoResumo> buscar(LancamentoFilter lancamentoFilter, Pageable pageable);
    
}
