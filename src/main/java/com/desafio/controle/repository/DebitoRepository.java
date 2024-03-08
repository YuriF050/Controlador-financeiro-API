
package com.desafio.controle.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.desafio.controle.model.Debitos;



@Repository 
public class DebitoRepository {
        private Integer ultimoId  = 0;
    private  List<Debitos> debitos = new ArrayList<>();

    public List<Debitos> obterTodos() {
        return debitos;
    }
    
    public Optional<Debitos> obterPorId(Integer id) {
        return debitos.stream().filter(debito -> debito.getId().equals(id)).findFirst();
    }
    
    public Debitos adicionar(Debitos debito) {
        ultimoId++;
        
        debito.setId(ultimoId);
        debitos.add(debito);

        return debito;
    }
    
    public void deletar(Integer id) {
        debitos.removeIf(debito -> debito.getId().equals(id));

    }

    public Debitos atualizar(Debitos debito){
        
        Optional<Debitos> valorEncontrado  = obterPorId(debito.getId());
        
        if(valorEncontrado.isEmpty()){
            throw new InputMismatchException("Valor não encontrado");
        }
        deletar(debito.getId());

        debitos.add(debito);

        return debito;
    }
    
}
