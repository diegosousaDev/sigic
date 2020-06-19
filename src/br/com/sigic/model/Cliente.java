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
    
    private String nivel;
    private String apelido;
    private String observacoes;

    public Cliente() {
    }   

    public Cliente(String nivel, String apelido, String observacoes, int id, String nome, String email, String cpf, String nascimento, StatusPessoa status, Telefone telefone, Endereco endereco) {
        super(id, nome, email, cpf, nascimento, status, telefone, endereco);
        this.nivel = nivel;
        this.apelido = apelido;
        this.observacoes = observacoes;
    }

    /**
     * @return the nivel
     */
    public String getNivel() {
        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(String nivel) {
        this.nivel = nivel;
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
     * @return the observacoes
     */
    public String getObservacoes() {
        return observacoes;
    }

    /**
     * @param observacoes the observacoes to set
     */
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public String toString() {
        return super.toString() + "Nível: " + nivel + ", " + "Apelido: " + apelido + ", " + "Observações: " + observacoes;
    }
}
