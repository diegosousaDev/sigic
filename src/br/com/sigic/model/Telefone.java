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
    private String tipo;
    private String ddd;
    private String numero;
    private String tipo1;
    private String ddd1;
    private String numero1;
    private String tipo2;
    private String ddd2;
    private String numero2;
    private Cliente cliente;
    private Funcionario funcionario;

    public Telefone() {
    }

    public Telefone(Integer id, String tipo, String ddd, String numero, String tipo1, String ddd1, String numero1, String tipo2, String ddd2, String numero2, Cliente cliente, Funcionario funcionario) {
        this.id = id;
        this.tipo = tipo;
        this.ddd = ddd;
        this.numero = numero;
        this.tipo1 = tipo1;
        this.ddd1 = ddd1;
        this.numero1 = numero1;
        this.tipo2 = tipo2;
        this.ddd2 = ddd2;
        this.numero2 = numero2;
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
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the ddd
     */
    public String getDdd() {
        return ddd;
    }

    /**
     * @param ddd the ddd to set
     */
    public void setDdd(String ddd) {
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
     * @return the tipo1
     */
    public String getTipo1() {
        return tipo1;
    }

    /**
     * @param tipo1 the tipo1 to set
     */
    public void setTipo1(String tipo1) {
        this.tipo1 = tipo1;
    }

    /**
     * @return the ddd1
     */
    public String getDdd1() {
        return ddd1;
    }

    /**
     * @param ddd1 the ddd1 to set
     */
    public void setDdd1(String ddd1) {
        this.ddd1 = ddd1;
    }

    /**
     * @return the numero1
     */
    public String getNumero1() {
        return numero1;
    }

    /**
     * @param numero1 the numero1 to set
     */
    public void setNumero1(String numero1) {
        this.numero1 = numero1;
    }

    /**
     * @return the tipo2
     */
    public String getTipo2() {
        return tipo2;
    }

    /**
     * @param tipo2 the tipo2 to set
     */
    public void setTipo2(String tipo2) {
        this.tipo2 = tipo2;
    }

    /**
     * @return the ddd2
     */
    public String getDdd2() {
        return ddd2;
    }

    /**
     * @param ddd2 the ddd2 to set
     */
    public void setDdd2(String ddd2) {
        this.ddd2 = ddd2;
    }

    /**
     * @return the numero2
     */
    public String getNumero2() {
        return numero2;
    }

    /**
     * @param numero2 the numero2 to set
     */
    public void setNumero2(String numero2) {
        this.numero2 = numero2;
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
