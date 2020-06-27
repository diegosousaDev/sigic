/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigic.dao;

import br.com.sigic.model.Funcionario;
import java.util.List;

/**
 *
 * @author ederc
 */
public interface FuncionarioDao {

    void insert(Funcionario obj);

    void update(Funcionario obj);

    void deleteById(Integer id);

    Funcionario findById(Integer id);
    
    List<Funcionario> findByName(String nome);

    List<Funcionario> findAll();

}
