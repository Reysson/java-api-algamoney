package com.reysson.algamoney.dto;

import com.reysson.algamoney.model.TipoLancamento;
import java.time.LocalDate;
import java.util.Objects;


public class LancamentoEstatiscaDia {

    private TipoLancamento tipo;
    
    private LocalDate dia;
    
    private Double total;

    public LancamentoEstatiscaDia(TipoLancamento tipo, LocalDate dia, Double total) {
        this.tipo = tipo;
        this.dia = dia;
        this.total = total;
    }

    public TipoLancamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoLancamento tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.tipo);
        hash = 53 * hash + Objects.hashCode(this.dia);
        hash = 53 * hash + Objects.hashCode(this.total);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LancamentoEstatiscaDia other = (LancamentoEstatiscaDia) obj;
        if (this.tipo != other.tipo) {
            return false;
        }
        if (!Objects.equals(this.dia, other.dia)) {
            return false;
        }
        if (!Objects.equals(this.total, other.total)) {
            return false;
        }
        return true;
    }

    
}
