/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigic.dao;

import br.com.sigic.model.TipoTel;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author ederc
 */
public interface TipoTelDao {

    void insert(TipoTel obj);

    void update(TipoTel obj);
    
    void deleteById(Integer id);

    TipoTel findById(Integer id);

    List<TipoTel> findAll();
    
    void mostraStatus(JComboBox<TipoTel> comboStatus);

}
