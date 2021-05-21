package com.reysson.algamoney.resource;

import com.reysson.algamoney.model.Pessoa;
import com.reysson.algamoney.repository.PessoaRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResources {
    
    @Autowired
    private PessoaRepository pessoaRepository;
    
    @GetMapping
    public List<Pessoa> listarTodos(){
        return pessoaRepository.findAll();
    }
    
    @PostMapping
    public Pessoa salvar(@Valid @RequestBody Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }
    
    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable("codigo") Integer id){
        pessoaRepository.deleteById(id);
    }
    
}
