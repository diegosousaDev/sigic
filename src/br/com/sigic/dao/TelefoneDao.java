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

    void insert(Telefone obj);

    void update(Telefone obj);

    Telefone findById(Integer id);

    List<Telefone> findAll();

}
