/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigic.dao;

import br.com.sigic.model.Telefone;
import java.util.List;

/**
 *
 * @author ederc
 */
public interface TelefoneDao {

    void insertCliente(Telefone obj);
    
    void insertFuncionario(Telefone obj);

    void updateCliente(Telefone obj);
    
    void updateFuncionario(Telefone obj);
    
    Telefone findById(Integer id);
    
    Telefone findByIdFuncionario(Integer id);

    List<Telefone> findAll();

}
