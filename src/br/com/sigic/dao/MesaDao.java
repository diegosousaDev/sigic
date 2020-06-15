/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigic.dao;

import br.com.sigic.model.Mesa;
import java.util.List;

/**
 *
 * @author ederc
 */
public interface MesaDao {

    void insert(Mesa obj);

    void update(Mesa obj);

    void deleteByNumero(Integer numero);

    Mesa findByNumero(Integer numero);

    List<Mesa> findAll();

}
