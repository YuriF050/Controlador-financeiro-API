package com.desafio.controle.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.desafio.controle.model.Debitos;
import com.desafio.controle.repository.DebitoRepository;

@Service
public class DebitosServices {
    
    @Autowired
    private DebitoRepository debitoRepository;

    public List<Debitos> obterTodos(){
        return debitoRepository.obterTodos();
    }


    public Optional<Debitos> obterPorId(Integer id) {
        
        return debitoRepository.obterPorId(id);
    }

    public Debitos adicionar(Debitos debito) {
        
        return debitoRepository.adicionar(debito);

    }
    public void deletar(Integer id) {
        
        debitoRepository.deletar(id); 

    }

    public Debitos atualizar(Integer id, Debitos debito){
        
        debito.setId(id);

        return debitoRepository.atualizar(debito);


    }

}

