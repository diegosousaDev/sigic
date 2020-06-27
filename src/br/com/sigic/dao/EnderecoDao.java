/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigic.dao;

import br.com.sigic.model.Endereco;
import java.util.List;

/**
 *
 * @author ederc
 */
public interface EnderecoDao {

    void insertCliente(Endereco obj);
    
    void insertFuncionario(Endereco obj);

    void updateCliente(Endereco obj);
    
    void updateFuncionario(Endereco obj);

    void deleteById(Integer id);

    Endereco findById(Integer id);
    
    Endereco findByIdFuncionario(Integer id);

    List<Endereco> findAll();

}
