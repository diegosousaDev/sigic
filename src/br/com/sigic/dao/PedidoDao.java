/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigic.dao;

import br.com.sigic.model.Pedido;
import java.util.List;

/**
 *
 * @author ederc
 */
public interface PedidoDao {

    void insert(Pedido obj);

    void update(Pedido obj);

    Pedido findById(Integer id);

    List<Pedido> findAll();

}
