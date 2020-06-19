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
    private Cliente cliente;
    private Funcionario funcionario;

    public Telefone() {
    }

    public Telefone(Integer id, TipoTel tipo, Integer ddd, String numero, Cliente cliente, Funcionario funcionario) {
        this.id = id;
        this.tipo = tipo;
        this.ddd = ddd;
        this.numero = numero;
        this.cliente = cliente;
        this.funcionario = funcionario;
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

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the funcionario
     */
    public Funcionario getFuncionario() {
        return funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }    
}
