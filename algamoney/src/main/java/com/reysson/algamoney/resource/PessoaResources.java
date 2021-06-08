package com.reysson.algamoney.resource;

import com.reysson.algamoney.model.Pessoa;
import com.reysson.algamoney.repository.PessoaRepository;
import com.reysson.algamoney.service.PessoaService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResources {
    
    @Autowired
    private PessoaRepository pessoaRepository;
    
    @Autowired
    private PessoaService pessoaService;
    
    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_PESSOA')")
    public List<Pessoa> listarTodos(){
        return pessoaRepository.findAll();
    }
    
    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_CADASTRAR_PESSOA')")
    public Pessoa salvar(@Valid @RequestBody Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }
    
    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('ROLE_REMOVER_PESSOA')")
    public void remover(@PathVariable("codigo") Integer id){
        pessoaRepository.deleteById(id);
    }
    
    @PutMapping("/{codigo}")
    @PreAuthorize("hasAuthority('ROLE_CADASTRAR_PESSOA')")
    public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable("codigo") Integer id,@RequestBody Pessoa pessoa){
        Pessoa pessoaAtualzada = this.pessoaService.atualizar(id, pessoa);
        return ResponseEntity.ok(pessoaAtualzada);
        
    }
    
}
