/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.recife.edu.ifpe.model.repositories;

import br.recife.edu.ifpe.model.entities.MetodoFila;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gusta
 */
public class MetodoFilaRepository {
    
    private static List<MetodoFila> metodosFila;
    
    static{
        metodosFila = new ArrayList<>();
        
        MetodoFila mf = new MetodoFila();
        mf.setCodigo(1);
        mf.setDescricaoCurta("Fila dentro do sapato");
        mf.setDescricaoLonga("Os estudantes estão colocando suas filas dentro do sapato");
        
        metodosFila.add(mf);
        
        mf = new MetodoFila();
        mf.setCodigo(2);
        mf.setDescricaoCurta("Fila na borracha");
        mf.setDescricaoLonga("Os estudantes estão passando as respostas na borracha um para o outro");
        
        metodosFila.add(mf);
    }
    
    public static void create(MetodoFila mf){
        MetodoFilaRepository.metodosFila.add(mf);
    }
    
    public static void update(MetodoFila mf){
        for(MetodoFila mfAux: metodosFila){
            
            if(mfAux.getCodigo() == mf.getCodigo()){
                mfAux.setDescricaoCurta(mf.getDescricaoCurta());
                mfAux.setDescricaoLonga(mf.getDescricaoLonga());
                
                return;
            }
        }
    }
    
    public static MetodoFila read(int codigo){
        for(MetodoFila mfAux: metodosFila){
            
            if(mfAux.getCodigo() == codigo){
                return mfAux;
            }
        }
        return null;
    }
    
    public static void delete(int codigo){
        for(int i = 0; i < metodosFila.size(); i++){
            
            if(metodosFila.get(i).getCodigo() == codigo){
                metodosFila.remove(i);
                return;
            }
        }
    }
    
    public static List<MetodoFila> readAll(){
        return metodosFila;
    }
}
