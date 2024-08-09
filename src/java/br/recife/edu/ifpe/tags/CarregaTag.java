/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.recife.edu.ifpe.tags;

import br.recife.edu.ifpe.model.repositories.CadeiraRepository;
import br.recife.edu.ifpe.model.repositories.EstudanteRepository;
import br.recife.edu.ifpe.model.repositories.MetodoFilaRepository;
import br.recife.edu.ifpe.model.repositories.ProfessorRepository;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author gusta
 */
public class CarregaTag extends SimpleTagSupport {
    
    private String entidade;
    private String var;
    private String escopo;
    private String codigo;

    public void setEntidade(String entidade) {
        this.entidade = entidade;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public void setEscopo(String escopo) {
        this.escopo = escopo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public void doTag() throws JspException, IOException {
        Object resultado = null;
        
        if("cadeira".equalsIgnoreCase(entidade)){
            if(codigo != null){
                int cod = Integer.parseInt(codigo);
                resultado = CadeiraRepository.read(cod);
            }else{               
                resultado = CadeiraRepository.readAll();
            }
        }else if("estudante".equalsIgnoreCase(entidade)){
            if(codigo != null){
                int cod = Integer.parseInt(codigo);
                resultado = EstudanteRepository.read(cod);
            }else{
                resultado = EstudanteRepository.readAll();
            }
        }else if("professor".equalsIgnoreCase(entidade)){
            if(codigo != null){
                int cod = Integer.parseInt(codigo);
                resultado = ProfessorRepository.read(cod);
            }else{
                resultado = ProfessorRepository.readAll();
            }
        }else if("metodoFila".equalsIgnoreCase(entidade)){
            if(codigo != null){
                int cod = Integer.parseInt(codigo);
                resultado = MetodoFilaRepository.read(cod);
            }else{
                resultado = MetodoFilaRepository.readAll();
            }
        }
        
        int scope = PageContext.PAGE_SCOPE;
        if ("requisicao".equalsIgnoreCase(escopo)) {
            scope = PageContext.REQUEST_SCOPE;
        } else if ("sessao".equalsIgnoreCase(escopo)) {
            scope = PageContext.SESSION_SCOPE;
        } else if ("aplicacao".equalsIgnoreCase(escopo)) {
            scope = PageContext.APPLICATION_SCOPE;
        }
        
        getJspContext().setAttribute(var, resultado, scope);
    }
    
    
}
