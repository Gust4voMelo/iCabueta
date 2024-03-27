/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.recife.edu.ife.model.entities;

import java.util.Date;

/**
 *
 * @author gusta
 */
public class Denuncia {

    private int codigo;
    private Date data;
    private String turno;
    private String descricaoDoOcorrido;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getDescricaoDoOcorrido() {
        return descricaoDoOcorrido;
    }

    public void setDescricaoDoOcorrido(String descricaoDoOcorrido) {
        this.descricaoDoOcorrido = descricaoDoOcorrido;
    }
    
    
}
