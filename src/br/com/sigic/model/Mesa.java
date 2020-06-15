/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigic.model;

/**
 *
 * @author ederc
 */
public class Mesa {
    
    private Integer numero;
    private Integer pessoas;
    private String status;

    public Mesa() {
    }

    public Mesa(Integer numero, Integer pessoas, String status) {
        this.numero = numero;
        this.pessoas = pessoas;
        this.status = status;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /**
     * @return the pessoas
     */
    public int getPessoas() {
        return pessoas;
    }

    /**
     * @param pessoas the pessoas to set
     */
    public void setPessoas(Integer pessoas) {
        this.pessoas = pessoas;
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
