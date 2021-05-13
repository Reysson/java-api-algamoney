package com.reysson.algamoney.resource;

import com.reysson.algamoney.model.Pessoa;
import com.reysson.algamoney.repository.PessoaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    
}
