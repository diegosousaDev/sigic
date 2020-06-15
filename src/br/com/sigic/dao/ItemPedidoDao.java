/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigic.dao;

import br.com.sigic.model.ItemPedido;
import java.util.List;

/**
 *
 * @author ederc
 */
public interface ItemPedidoDao {

    void insert(ItemPedido obj);

    void update(ItemPedido obj);

    ItemPedido findById(Integer id);

    List<ItemPedido> findAll();

}
