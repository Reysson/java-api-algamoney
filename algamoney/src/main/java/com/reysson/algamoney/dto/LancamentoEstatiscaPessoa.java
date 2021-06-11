package com.reysson.algamoney.dto;

import com.reysson.algamoney.model.Pessoa;
import com.reysson.algamoney.model.TipoLancamento;

public class LancamentoEstatiscaPessoa {

    private TipoLancamento tipo;
    private Pessoa pessoa;
    private Double total;

    public LancamentoEstatiscaPessoa(TipoLancamento tipo, Pessoa pessoa, Double total) {
        this.tipo = tipo;
        this.pessoa = pessoa;
        this.total = total;
    }

    public TipoLancamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoLancamento tipo) {
        this.tipo = tipo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
    

}
