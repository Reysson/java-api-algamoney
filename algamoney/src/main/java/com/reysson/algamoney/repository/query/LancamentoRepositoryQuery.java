package com.reysson.algamoney.repository.query;

import com.reysson.algamoney.model.Lancamento;
import com.reysson.algamoney.repository.filter.LancamentoFilter;
import java.util.List;


public interface LancamentoRepositoryQuery {
     
    public List<Lancamento> filtrar(LancamentoFilter lancamentoFilter);
    
}
