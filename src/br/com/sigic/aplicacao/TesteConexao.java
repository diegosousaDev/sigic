/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigic.aplicacao;

import br.com.sigic.db.Db;
import java.sql.Connection;

/**
 *
 * @author ederc
 */
public class TesteConexao {
    
    public static void main(String[] args) {
        
        Connection conn = Db.getConnection();
        System.out.println(conn);
        
    }
    
}
