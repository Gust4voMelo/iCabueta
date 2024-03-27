/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.recife.edu.ife.model.repositories;

import br.recife.edu.ife.model.entities.Estudante;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gusta
 */
public class EstudanteRepository {
    
    private static List<Estudante> estudantes;
    
    static{
        estudantes = new ArrayList<>();
        
        Estudante e = new Estudante();
        e.setCodigo(1);
        e.setNome("Gustavo");
        e.setEmail("dedoduro@discente.ifpe.edu.br");
        e.setSenha("senhaMtDificil123");
        e.setAnoEntrada(2022);
        
        estudantes.add(e);
        
        e = new Estudante();
        e.setCodigo(2);
        e.setNome("Raul");
        e.setEmail("dedoduro2@discente.ifpe.edu.br");
        e.setSenha("senhaMtFacil123");
        e.setAnoEntrada(2022);
        
        estudantes.add(e); 
    }
    
    public static void create(Estudante e){
        EstudanteRepository.estudantes.add(e);
    }
    
    public static void update(Estudante e){
        
        for(Estudante eAux: estudantes){
            
            if(eAux.getCodigo() == e.getCodigo()){
                eAux.setAnoEntrada(e.getAnoEntrada());
                eAux.setEmail(e.getEmail());
                eAux.setNome(e.getNome());
                eAux.setSenha(e.getSenha());
                
                return;
            }
        }
    }
    
    public static Estudante read(int codigo){
        
        for(Estudante eAux: estudantes){
            if(eAux.getCodigo() == codigo){
                return eAux;
            }
        }
        return null;
    }
    
    public static void delete(int codigo){
        
        for(int i = 0; i < estudantes.size(); i++){
            
            if(estudantes.get(i).getCodigo() == codigo){
                estudantes.remove(i);
                return;
            }
        }
    }
    
    public static List<Estudante> readAll(){
        return estudantes;
    }
}
