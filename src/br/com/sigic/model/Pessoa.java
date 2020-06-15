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
public class Pessoa {
    
    private Integer id;
    private String nome;
    private String email;
    private String cpf;
    private Date nascimento;
    private StatusPessoa status;
    private Categoria categoria;
    private Telefone telefone;
    private Endereco endereco;

    public Pessoa() {
    }

    public Pessoa(Integer id, String nome, String email, String cpf, Date nascimento, StatusPessoa status, Categoria categoria, Telefone telefone, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.status = status;
        this.categoria = categoria;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the nascimento
     */
    public Date getNascimento() {
        return nascimento;
    }

    /**
     * @param nascimento the nascimento to set
     */
    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    /**
     * @return the status
     */
    public StatusPessoa getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(StatusPessoa status) {
        this.status = status;
    }

    /**
     * @return the categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the telefone
     */
    public Telefone getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the endereco
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Id: " + id + ", " + "E-mail: " + email + ", " + "Cpf: " + cpf + ", " + "Data de Nascimento: " + nascimento + ", "
                + "Status: " + status + ", " + "Categoria: " + categoria + ", " + "Telefone: " + telefone + ", " + "Endereco: " + endereco + ", "; 
    }
}
