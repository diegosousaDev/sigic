/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigic.dao;

import br.com.sigic.model.TipoTel;
import java.util.List;

/**
 *
 * @author ederc
 */
public interface TipoTelDao {

    void insert(TipoTel obj);

    void update(TipoTel obj);

    TipoTel findById(Integer id);

    List<TipoTel> findAll();

}
