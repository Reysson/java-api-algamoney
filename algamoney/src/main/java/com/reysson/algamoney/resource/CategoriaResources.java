package com.reysson.algamoney.resource;

import com.reysson.algamoney.model.Categoria;
import com.reysson.algamoney.repository.CategoriaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResources {
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Categoria> listarTodas(){
        return categoriaRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id){
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if(categoria.isEmpty()){
            return ResponseEntity.notFound().build();
        } 
        return ResponseEntity.ok(categoria.get());
    }
}
