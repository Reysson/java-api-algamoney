package com.reysson.algamoney.repository.query;

import com.reysson.algamoney.model.Lancamento;
import com.reysson.algamoney.repository.filter.LancamentoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface LancamentoRepositoryQuery {
     
    public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);
    
}
