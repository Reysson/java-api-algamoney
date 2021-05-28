
package com.reysson.algamoney.repository;

import com.reysson.algamoney.model.Lancamento;
import com.reysson.algamoney.repository.query.LancamentoRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Integer>, LancamentoRepositoryQuery{
    
}
