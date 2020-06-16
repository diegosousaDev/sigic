/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigic.dao;

import br.com.sigic.dao.impl.ClienteDaoJDBC;
import br.com.sigic.dao.impl.FuncionarioDaoJDBC;
import br.com.sigic.dao.impl.TipoTelDaoJDBC;
import br.com.sigic.db.Db;

/**
 *
 * @author ederc
 */
public class DaoFactory {
    
    public static ClienteDao criarClienteDao(){
        return new ClienteDaoJDBC(Db.getConnection());
    }
    
    public static FuncionarioDao criarFuncionarioDao(){
        return new FuncionarioDaoJDBC(Db.getConnection());
    }
    
    public static TipoTelDao criarTipoTelDao(){
        return new TipoTelDaoJDBC(Db.getConnection());
    }
    
}
