/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigic.dao;

import br.com.sigic.model.Produto;
import java.util.List;

/**
 *
 * @author ederc
 */
public interface ProdutoDao {

    void insert(Produto obj);

    void update(Produto obj);

    Produto findById(Integer id);

    List<Produto> findAll();

}
