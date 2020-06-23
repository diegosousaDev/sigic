/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigic.dao;

import br.com.sigic.model.Cliente;
import java.util.List;

/**
 *
 * @author ederc
 */
public interface ClienteDao {

    void insert(Cliente obj);

    void update(Cliente obj);

    void deleteById(Integer id);

    Cliente findById(Integer id);
    
    List<Cliente> findByName(String nome);

    List<Cliente> findAll();

}
