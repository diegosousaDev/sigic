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
public class Funcionario extends Pessoa{
    
    private String funcao;
    private String senha;
    private String status;

    public Funcionario() {
    }

    public Funcionario(String funcao, String senha, String status, int id, String nome, String email, String cpf, Date nascimento, Telefone telefone, Endereco endereco) {
        super(id, nome, email, cpf, nascimento, telefone, endereco);
        this.funcao = funcao;
        this.senha = senha;
        this.status = status;
    }

    /**
     * @return the funcao
     */
    public String getFuncao() {
        return funcao;
    }

    /**
     * @param funcao the funcao to set
     */
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
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
