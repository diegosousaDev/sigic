/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigic.dao.impl;

import java.sql.*;
import br.com.sigic.db.Db;
import br.com.sigic.db.DbException;
import br.com.sigic.dao.TelefoneDao;
import br.com.sigic.model.Telefone;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ederc
 */
public class TelefoneDaoJDBC implements TelefoneDao {

    public TelefoneDaoJDBC() {
    }

    private Connection conn;

    public TelefoneDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Telefone obj) {

        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("INSERT INTO tb_telefone "
                    + "(ddd, numero, tipo_telefone )"
                    + "VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);

            st.setInt(1, obj.getDdd());
            st.setString(2, obj.getNumero());
            st.setInt(3, obj.getTipo().getId());
                        
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
    public void update(Telefone obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("UPDATE tb_telefone SET ddd = ?, numero = ? "
                    + "WHERE Id = ?");

            st.setInt(1, obj.getDdd());
            st.setString(2, obj.getNumero());
            st.setInt(3, obj.getId());

            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException("Erro: " + e.getMessage());
        } finally {
            Db.closeStatement(st);
        }
    }

    @Override
    public Telefone findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * "
                    + "FROM tb_telefone "
                    + "WHERE id = ? ");

            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                Telefone obj = new Telefone();
                obj.setId(rs.getInt("id"));
                obj.setDdd(rs.getInt("ddd"));
                obj.setNumero(rs.getString("numero"));
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
    public List<Telefone> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {

            st = conn.prepareStatement("SELECT * FROM tb_telefone "
                    + "ORDER BY nome");

            rs = st.executeQuery();

            List<Telefone> telefones = new ArrayList<>();

            while (rs.next()) {
                Telefone obj = new Telefone();
                obj.setId(rs.getInt("id"));
                obj.setDdd(rs.getInt("ddd"));
                obj.setNumero(rs.getString("numero"));                  
                telefones.add(obj);
            }
            return telefones;
        } catch (SQLException erro) {
            throw new DbException(erro.getMessage());
        } finally {
            Db.closeStatement(st);
            Db.closeResultSet(rs);
        }
    }
}
