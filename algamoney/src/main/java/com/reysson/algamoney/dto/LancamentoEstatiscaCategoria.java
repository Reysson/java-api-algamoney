package com.reysson.algamoney.dto;

import com.reysson.algamoney.model.Categoria;

public class LancamentoEstatiscaCategoria {

    private Categoria categoria;

    private Double total;

    public LancamentoEstatiscaCategoria(Categoria categoria, Double total) {
        this.categoria = categoria;
        this.total = total;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

}
