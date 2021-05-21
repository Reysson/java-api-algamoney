package com.reysson.algamoney.service;

import com.reysson.algamoney.model.Pessoa;
import com.reysson.algamoney.repository.PessoaRepository;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepository pessoaRepository;
    
    public Pessoa atualizar(Integer id, Pessoa pessoa){
        Optional<Pessoa> pessoaBuscada = pessoaRepository.findById(id);
        if(pessoaBuscada.isEmpty()){
            throw new EmptyResultDataAccessException(1);
        }
        BeanUtils.copyProperties(pessoa, pessoaBuscada,"codigo");
        return pessoaRepository.save(pessoaBuscada.get());
        
    }
}
