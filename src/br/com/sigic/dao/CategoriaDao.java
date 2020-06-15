/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigic.dao;

import br.com.sigic.model.Categoria;
import java.util.List;

/**
 *
 * @author ederc
 */
public interface CategoriaDao {

    void insert(Categoria obj);

    void update(Categoria obj);

    void deleteById(Integer id);

    Categoria findById(Integer id);

    List<Categoria> findAll();

}
