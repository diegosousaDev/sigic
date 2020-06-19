/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigic.dao.impl;

import br.com.sigic.model.StatusPessoa;

import java.sql.*;
import br.com.sigic.db.Db;
import br.com.sigic.db.DbException;
import br.com.sigic.dao.StatusPessoaDao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author ederc
 */
public class StatusPessoaDaoJDBC implements StatusPessoaDao {

    public StatusPessoaDaoJDBC() {
    }

    private Connection conn;

    public StatusPessoaDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(StatusPessoa obj) {

        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("INSERT INTO tb_statuspessoa "
                    + "(descricao )"
                    + "VALUES (?)", Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getDescricao());
                        
            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setId(id);
                    Db.closeResultSet(rs);
                } else {
                    throw new DbException("Erro inesperado, nenhuma linha foi alterada.");
                }
            }
        } catch (SQLException e) {
            throw new DbException("Erro: " + e.getMessage());
        } finally {
            Db.closeStatement(st);
        }
    }

    @Override
    public void update(StatusPessoa obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("UPDATE tb_statuspessoa SET descricao = ? "
                    + "WHERE Id = ?");

            st.setString(1, obj.getDescricao());
            st.setInt(2, obj.getId());

            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException("Erro: " + e.getMessage());
        } finally {
            Db.closeStatement(st);
        }
    }

    @Override
    public StatusPessoa findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * "
                    + "FROM tb_statuspessoa "
                    + "WHERE id = ? ");

            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                StatusPessoa obj = new StatusPessoa();
                obj.setId(rs.getInt("id"));
                obj.setDescricao(rs.getString("descricao"));
                return obj;
            }
            return null;
        } catch (SQLException erro) {
            throw new DbException(erro.getMessage());
        } finally {
            Db.closeStatement(st);
            Db.closeResultSet(rs);
        }
    }
    
    @Override
    public void deleteById(Integer id) {
         
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("DELETE FROM tb_statuspessoa WHERE id = ?");

            st.setInt(1, id);

            int rows = st.executeUpdate();

            if (rows == 0) {
                JOptionPane.showMessageDialog(null, "Id não localizado.");
            }
        } catch (SQLException erro) {
            throw new DbException(erro.getMessage());
        } finally {
            Db.closeStatement(st);
        }
    }

    @Override
    public List<StatusPessoa> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {

            st = conn.prepareStatement("SELECT * FROM tb_statuspessoa "
                    + "ORDER BY descricao");

            rs = st.executeQuery();

            List<StatusPessoa> status = new ArrayList<>();

            while (rs.next()) {
                StatusPessoa obj = new StatusPessoa();
                obj.setId(rs.getInt("id"));
                obj.setDescricao(rs.getString("descricao"));                        
                status.add(obj);
            }
            return status;
        } catch (SQLException erro) {
            throw new DbException(erro.getMessage());
        } finally {
            Db.closeStatement(st);
            Db.closeResultSet(rs);
        }
    }
    @Override
    public void mostraStatus(JComboBox<StatusPessoa> comboStatus){
        
        PreparedStatement st = null;
        ResultSet rs = null;
        try {

            st = conn.prepareStatement("SELECT * FROM tb_statuspessoa "
                    + "ORDER BY descricao");

            rs = st.executeQuery();

            while (rs.next()) {
                StatusPessoa obj = new StatusPessoa();
                obj.setId(rs.getInt("id"));
                obj.setDescricao(rs.getString("descricao"));
                comboStatus.addItem(obj);
            }
            
        } catch (SQLException erro) {
            throw new DbException(erro.getMessage());
        } finally {
            Db.closeStatement(st);
            Db.closeResultSet(rs);
        }
        
    }
    
}
