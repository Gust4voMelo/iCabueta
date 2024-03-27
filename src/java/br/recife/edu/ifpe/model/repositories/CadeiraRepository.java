/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.recife.edu.ifpe.model.repositories;

import br.recife.edu.ifpe.model.entities.Cadeira;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gusta
 */
public class CadeiraRepository {
    
    private static List<Cadeira> cadeiras;
    
    static{
        cadeiras = new ArrayList<>();
        
        Cadeira c = new Cadeira();
        c.setAno(2024);
        c.setCodigo(1);
        c.setDescricao("Aprender a desenvolver site bonitinho e funcional para web");
        c.setNome("Web2");
        c.setSemestre(4);
        
        cadeiras.add(c);
        
        c = new Cadeira();
        c.setAno(2024);
        c.setCodigo(2);
        c.setDescricao("Aprender a ser um desenvolvedor e não um programador");
        c.setNome("PDS");
        c.setSemestre(4);
        
        cadeiras.add(c);
    }
    
    public static void create(Cadeira c){
        CadeiraRepository.cadeiras.add(c);
    }
    
    public static void update(Cadeira c){
        for(Cadeira cAux: cadeiras){
            if(cAux.getCodigo() == c.getCodigo()){
                cAux.setAno(c.getAno());
                cAux.setDescricao(c.getDescricao());
                cAux.setNome(c.getNome());
                cAux.setSemestre(c.getSemestre());
                
                return;
            }
        }
    }
    
    public static Cadeira read(int codigo){
        for(Cadeira cAux: cadeiras){
            if(cAux.getCodigo() == codigo){
                return cAux;
            }
        }
        
        return null;
    }
    
    public static void delete(int codigo){
        for(int i = 0; i < cadeiras.size(); i++){
            if(cadeiras.get(i).getCodigo() == codigo){
                cadeiras.remove(i);
                return;
            }
        }
    }
    
    public static List<Cadeira> readAll(){
        return cadeiras;
    }
}
