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
public class Telefone {
    
    private Integer id;
    private TipoTel tipo;
    private Integer ddd;
    private String numero;

    public Telefone() {
    }

    public Telefone(Integer id, TipoTel tipo, Integer ddd, String numero) {
        this.id = id;
        this.tipo = tipo;
        this.ddd = ddd;
        this.numero = numero;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the tipo
     */
    public TipoTel getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoTel tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the ddd
     */
    public Integer getDdd() {
        return ddd;
    }

    /**
     * @param ddd the ddd to set
     */
    public void setDdd(Integer ddd) {
        this.ddd = ddd;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

   
}
