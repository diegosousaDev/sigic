/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigic.dao.impl;

import br.com.sigic.model.Mesa;

import java.sql.*;
import br.com.sigic.db.Db;
import br.com.sigic.db.DbException;
import br.com.sigic.dao.MesaDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ederc
 */
public class MesaDaoJDBC implements MesaDao {

    public MesaDaoJDBC() {
    }

    private Connection conn;

    public MesaDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Mesa obj) {

        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("INSERT INTO tb_mesa"
                    + "(numero, qtd_pessoas, status)"
                    + "VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);

            st.setInt(1, obj.getNumero());
            st.setInt(2, obj.getPessoas());
            st.setString(3, obj.getStatus());
            
            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int numero = rs.getInt(1);
                    obj.setNumero(numero);
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
    public void update(Mesa obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("UPDATE tb_mesa SET qtd_pessoas = ?, status = ? WHERE  numero = ?");

            st.setInt(1, obj.getPessoas());
            st.setString(2, obj.getStatus());
            st.setInt(3, obj.getNumero());

            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException("Erro: " + e.getMessage());
        } finally {
            Db.closeStatement(st);
        }
    }

    @Override
    public void deleteByNumero(Integer numero) {

        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("DELETE FROM tb_mesa WHERE numero = ?");

            st.setInt(1, numero);

            int rows = st.executeUpdate();

            if (rows == 0) {
                throw new DbException("Id Não localizado.");
            } else {
                System.out.println("Deletado com sucesso!");
            }
        } catch (SQLException erro) {
            throw new DbException(erro.getMessage());
        } finally {
            Db.closeStatement(st);
        }
    }

    @Override
    public Mesa findByNumero(Integer numero) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * "
                    + "FROM tb_mesa "
                    + "WHERE numero = ? ");

            st.setInt(1, numero);
            rs = st.executeQuery();

            if (rs.next()) {
                Mesa obj = new Mesa();
                obj.setNumero(rs.getInt("numero"));
                obj.setPessoas(rs.getInt("qtd_pessoas"));
                obj.setStatus(rs.getString("status"));
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
    public List<Mesa> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {

            st = conn.prepareStatement("SELECT * FROM tb_mesa "
                    + "ORDER BY numero");

            rs = st.executeQuery();

            List<Mesa> mesas = new ArrayList<>();

            while (rs.next()) {
                Mesa obj = new Mesa();
                obj.setNumero(rs.getInt("numero"));
                obj.setPessoas(rs.getInt("qtd_pessoas"));
                obj.setStatus(rs.getString("status"));
                
                mesas.add(obj);
            }
            return mesas;
        } catch (SQLException erro) {
            throw new DbException(erro.getMessage());
        } finally {
            Db.closeStatement(st);
            Db.closeResultSet(rs);
        }
    }
    
    
    
}
