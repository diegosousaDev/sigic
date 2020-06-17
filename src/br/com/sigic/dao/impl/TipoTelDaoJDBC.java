/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigic.dao.impl;

import java.sql.*;
import br.com.sigic.db.Db;
import br.com.sigic.db.DbException;
import br.com.sigic.dao.TipoTelDao;
import br.com.sigic.model.TipoTel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ederc
 */
public class TipoTelDaoJDBC implements TipoTelDao {

    public TipoTelDaoJDBC() {
    }

    private Connection conn;

    public TipoTelDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(TipoTel obj) {

        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("INSERT INTO tipo_telefone "
                    + "(tipo )"
                    + "VALUES (?)", Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getTipo());
                        
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
    public void update(TipoTel obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("UPDATE tipo_telefone SET tipo = ? "
                    + "WHERE Id = ?");

            st.setString(1, obj.getTipo());
            st.setInt(2, obj.getId());

            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException("Erro: " + e.getMessage());
        } finally {
            Db.closeStatement(st);
        }
    }

    @Override
    public TipoTel findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * "
                    + "FROM tipo_telefone "
                    + "WHERE id = ? ");

            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                TipoTel obj = new TipoTel();
                obj.setId(rs.getInt("id"));
                obj.setTipo(rs.getString("tipo"));
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
            st = conn.prepareStatement("DELETE FROM tipo_telefone WHERE id = ?");

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
    public List<TipoTel> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {

            st = conn.prepareStatement("SELECT * FROM tipo_telefone "
                    + "ORDER BY id");

            rs = st.executeQuery();

            List<TipoTel> tipos = new ArrayList<>();

            while (rs.next()) {
                TipoTel obj = new TipoTel();
                obj.setId(rs.getInt("id"));
                obj.setTipo(rs.getString("tipo"));                        
                tipos.add(obj);
            }
            return tipos;
        } catch (SQLException erro) {
            throw new DbException(erro.getMessage());
        } finally {
            Db.closeStatement(st);
            Db.closeResultSet(rs);
        }
    }
}
