package com.desafio.controle.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.desafio.controle.model.Creditos;
import com.desafio.controle.repository.CreditoRepository;

@Service
public class CreditosServices {
    
    @Autowired
    private CreditoRepository creditoRepository;


    public List<Creditos> obterTodos(){
        return creditoRepository.obterTodos();
    }

    public Optional<Creditos> obterPorId(Integer id) {
        
        return creditoRepository.obterPorId(id);
    }

    public Creditos adicionar(Creditos credito) {
        
        return creditoRepository.adicionar(credito);

    }
    public void deletar(Integer id) {
        
        creditoRepository.deletar(id); 

    }

    public Creditos atualizar(Integer id, Creditos credito){
        
        credito.setId(id);
        return creditoRepository.atualizar(credito);


    }

}
