package com.reysson.algamoney.resource;

import com.reysson.algamoney.model.Lancamento;
import com.reysson.algamoney.repository.LancamentoRepository;
import com.reysson.algamoney.repository.filter.LancamentoFilter;
import com.reysson.algamoney.repository.projecao.LancamentoResumo;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoResources {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_LANCAMENTO')")
    public Page<Lancamento> pesquisar(LancamentoFilter filter, Pageable pageable) {
        return lancamentoRepository.filtrar(filter,pageable);
    }
    
    @GetMapping(params = "resumo")
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_LANCAMENTO')")
    public Page<LancamentoResumo> resumir(LancamentoFilter filter, Pageable pageable) {
        return lancamentoRepository.buscar(filter,pageable);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_LANCAMENTO')")
    public ResponseEntity<Lancamento> buscarPorId(@PathVariable Integer id) {
        Optional<Lancamento> lancamento = lancamentoRepository.findById(id);
        if (lancamento.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }
        return ResponseEntity.ok(lancamento.get());

    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('ROLE_CADATRAR_LANCAMENTO')")
    public Lancamento salvar(@Valid @RequestBody Lancamento lancamento){
        return lancamentoRepository.save(lancamento);
    }

}
