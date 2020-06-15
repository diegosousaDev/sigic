/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigic.model;

import br.com.sigic.model.enums.StatusPedido;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ederc
 */
public class Pedido {
    
    private Integer id;
    private Date data;
    private String observacao;
    private StatusPedido statusPedido;
    private Cliente cliente;
    private Funcionario funcionario;
    private Mesa mesa;
    
    private List<ItemPedido> itens = new ArrayList<>();

    public Pedido() {
    }

    public Pedido(Integer id, Date data, String observacao,StatusPedido statusPedido, Cliente cliente, Funcionario funcionario, Mesa mesa) {
        this.id = id;
        this.data = data;
        this.observacao = observacao;
        this.statusPedido = statusPedido;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.mesa = mesa;
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
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the observacao
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * @param observacao the observacao to set
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    
    
    /**
     * @return the statusPedido
     */
    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    /**
     * @param statusPedido the statusPedido to set
     */
    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
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

    /**
     * @return the mesa
     */
    public Mesa getMesa() {
        return mesa;
    }

    /**
     * @param mesa the mesa to set
     */
    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    /**
     * @return the itens
     */
    public List<ItemPedido> getItens() {
        return itens;
    }

    /**
     * @param itens the itens to set
     */
    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }
        
    public Double getTotal(){
        double somar = 0;
        for(ItemPedido item : itens){
            somar += item.getSubTotal();
        }
        return somar;
    }
}
