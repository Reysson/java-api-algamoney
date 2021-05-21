package com.reysson.algamoney.resource;

import com.reysson.algamoney.model.Lancamento;
import com.reysson.algamoney.repository.LancamentoRepository;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public List<Lancamento> buscarTodos() {
        return lancamentoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lancamento> buscarPorId(@PathVariable Integer id) {
        Optional<Lancamento> lancamento = lancamentoRepository.findById(id);
        if (lancamento.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }
        return ResponseEntity.ok(lancamento.get());

    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Lancamento salvar(@Valid @RequestBody Lancamento lancamento){
        return lancamentoRepository.save(lancamento);
    }

}
