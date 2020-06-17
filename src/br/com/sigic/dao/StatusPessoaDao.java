/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigic.dao;

import br.com.sigic.model.StatusPessoa;
import java.util.List;

/**
 *
 * @author ederc
 */
public interface StatusPessoaDao {

    void insert(StatusPessoa obj);

    void update(StatusPessoa obj);
    
    void deleteById(Integer id);

    StatusPessoa findById(Integer id);

    List<StatusPessoa> findAll();

}
