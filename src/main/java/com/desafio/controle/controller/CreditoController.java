package com.desafio.controle.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.controle.model.Creditos;
import com.desafio.controle.services.CreditosServices;

import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/controle/credito")
public class CreditoController {
    
    @Autowired
    private CreditosServices creditoServices;

    @GetMapping
    public List<Creditos> obterTodos(){
        return creditoServices.obterTodos();
    }

    @GetMapping("/{id}")
    public Optional<Creditos> obterPorId(@PathVariable Integer id){
        return creditoServices.obterPorId(id);
    }

    @PostMapping
    public Creditos adicionar (@RequestBody Creditos credito){
        return creditoServices.adicionar(credito);
    }
    
    @PutMapping("/{id}")
    public Creditos atualizar(@PathVariable Integer id,@RequestBody Creditos credito ){

        return creditoServices.atualizar(id, credito);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id){

        creditoServices.deletar(id); 
        return "Credito com o id " + id + " foi deletado com sucesso!";
    }
}
