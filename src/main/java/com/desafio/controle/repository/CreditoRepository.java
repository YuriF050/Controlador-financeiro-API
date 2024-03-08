
package com.desafio.controle.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.desafio.controle.model.Creditos;



@Repository 
public class CreditoRepository {
        private Integer ultimoId  = 0;
    private  List<Creditos> creditos = new ArrayList<>();
    public List<Creditos> obterTodos() {
        return creditos;
    }
    
    public Optional<Creditos> obterPorId(Integer id) {
        return creditos.stream().filter(credito -> credito.getId().equals(id)).findFirst();
    }
    
    public Creditos adicionar(Creditos credito) {
        ultimoId++;

        credito.setId(ultimoId);
        creditos.add(credito);

        return credito;
    }
    
    public void deletar(Integer id) {
        creditos.removeIf(credito -> credito.getId().equals(id));

    }

    public Creditos atualizar(Creditos credito){
        
        Optional<Creditos> valorEncontrado  = obterPorId(credito.getId());
        
        if(valorEncontrado.isEmpty()){
            throw new InputMismatchException("Valor não encontrado");
        }
        deletar(credito.getId());

        creditos.add(credito);

        return credito;
    }
    
}
