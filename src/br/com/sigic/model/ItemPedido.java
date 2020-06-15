/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigic.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ederc
 */
public class ItemPedido {
    
    private Integer quantidade;
    private Double preco;
    private Double desconto;
    private Pedido pedido;
    
    private List<Produto> produtos = new ArrayList<>();

    public ItemPedido() {
    }

    public ItemPedido(Integer quantidade, Double preco, Double desconto, Pedido pedido) {
        this.quantidade = quantidade;
        this.preco = new Produto().getPreco();
        this.desconto = desconto;
        this.pedido = pedido;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the preco
     */
    public Double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(Double preco) {
        this.preco = preco;
    }

    /**
     * @return the desconto
     */
    public Double getDesconto() {
        return desconto;
    }

    /**
     * @param desconto the desconto to set
     */
    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    /**
     * @return the pedido
     */
    public Pedido getPedido() {
        return pedido;
    }

    /**
     * @param pedido the pedido to set
     */
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    /**
     * @return the produtos
     */
    public List<Produto> getProdutos() {
        return produtos;
    }

    /**
     * @param produtos the produtos to set
     */
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    
   public Double getSubTotal(){
       return quantidade * preco;
   }


}
