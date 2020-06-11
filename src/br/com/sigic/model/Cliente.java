/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigic.model;

import java.util.Date;

/**
 *
 * @author ederc
 */
public class Cliente extends Pessoa{
    
    private String apelido;
    private String status;

    public Cliente() {
    }   

    public Cliente(String apelido, String status, int id, String nome, String email, String cpf, Date nascimento, Telefone telefone, Endereco endereco) {
        super(id, nome, email, cpf, nascimento, telefone, endereco);
        this.apelido = apelido;
        this.status = status;
    }

    /**
     * @return the apelido
     */
    public String getApelido() {
        return apelido;
    }

    /**
     * @param apelido the apelido to set
     */
    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
    
}
