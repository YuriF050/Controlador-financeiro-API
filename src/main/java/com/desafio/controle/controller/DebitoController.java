package com.desafio.controle.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.controle.model.Debitos;
import com.desafio.controle.services.DebitosServices;

@RestController
@RequestMapping("/api/controle/debito")
public class DebitoController {
    
    @Autowired
    private DebitosServices debitoServices;

    @GetMapping
    public List<Debitos> obterTodos(){
        return debitoServices.obterTodos();
    }

    @GetMapping("/{id}")
    public Optional<Debitos> obterPorId(@PathVariable Integer id){
        return debitoServices.obterPorId(id);
    }

    @PostMapping
    public Debitos adicionar (@RequestBody Debitos debito){
        return debitoServices.adicionar(debito);
    }
    
    @PutMapping("/{id}")
    public Debitos atualizar(@PathVariable Integer id,@RequestBody Debitos debito ){

        return debitoServices.atualizar(id, debito);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id){

        debitoServices.deletar(id); 
        return "Debito com o id " + id + " foi deletado com sucesso!";
    }
}
