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
    
    private Date data_admissao;
    private Date data_saida;
    private String funcao;
    private String carteira;

    public Funcionario() {
    }

    public Funcionario(Date data_admissao, Date data_saida, String funcao, String carteira, int id, String nome, String email, String cpf, Date nascimento, StatusPessoa status, Telefone telefone, Endereco endereco) {
        super(id, nome, email, cpf, nascimento, status, telefone, endereco);
        this.data_admissao = data_admissao;
        this.data_saida = data_saida;
        this.funcao = funcao;
        this.carteira = carteira;
    }

    /**
     * @return the data_admissao
     */
    public Date getData_admissao() {
        return data_admissao;
    }

    /**
     * @param data_admissao the data_admissao to set
     */
    public void setData_admissao(Date data_admissao) {
        this.data_admissao = data_admissao;
    }

    /**
     * @return the data_saida
     */
    public Date getData_saida() {
        return data_saida;
    }

    /**
     * @param data_saida the data_saida to set
     */
    public void setData_saida(Date data_saida) {
        this.data_saida = data_saida;
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
     * @return the carteira
     */
    public String getCarteira() {
        return carteira;
    }

    /**
     * @param carteira the carteira to set
     */
    public void setCarteira(String carteira) {
        this.carteira = carteira;
    }   
}
