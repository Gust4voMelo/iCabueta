/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.recife.edu.ife.model.repositories;

import br.recife.edu.ife.model.entities.Professor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gusta
 */
public class ProfessorRepository {
    
    private static List<Professor> professores;
    
    static{
        professores = new ArrayList<>();
        
        Professor p = new Professor();
        p.setCodigo(1);
        p.setEmail("einsteinRelativo@professor.ifpe.edu.br");
        p.setNome("Einstein");
        p.setSenha("Chocante321");
        
        professores.add(p);
        
        p = new Professor();
        p.setCodigo(2);
        p.setEmail("newtonDaMaca@professor.ifpe.edu.br");
        p.setNome("Newton");
        p.setSenha("MaçaBichada123");
        
        professores.add(p);
    }
    
    public static void create(Professor p){
        ProfessorRepository.professores.add(p);
    }
    
    public static void update(Professor p){
        
        for(Professor pAux: professores){
            
            if(pAux.getCodigo() == p.getCodigo()){
                pAux.setEmail(p.getEmail());
                pAux.setNome(p.getNome());
                pAux.setSenha(p.getSenha());
                
                return;
            }
        }
    }
    
    public static Professor read(int codigo){
        
        for(Professor pAux: professores){
            if(pAux.getCodigo() == codigo){
                return pAux;
            }
        }
        return null;
    }
    
    public static void delete(int codigo){
        
        for(int i = 0; i < professores.size(); i++){
            
            if(professores.get(i).getCodigo() == codigo){
                professores.remove(i);
                return;
            }
        } 
    }
    
    public static List<Professor> readAll(){
        return professores;
    }
}
