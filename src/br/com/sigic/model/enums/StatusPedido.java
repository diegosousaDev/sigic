/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigic.model.enums;

/**
 *
 * @author ederc
 */
public enum StatusPedido {
    
    AGUARDANDO(1), EM_PREPARO(2), ENTREGUE(3), CANCELADO(4);

    private int valor;
    
    StatusPedido(int valor) {
        this.valor = valor;
    } 
}
