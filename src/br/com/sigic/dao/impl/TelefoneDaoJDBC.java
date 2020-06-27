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
    public void insertCliente(Telefone obj) {

        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("INSERT INTO tb_telefone "
                    + "(tipo_telefone, ddd, numero, tipo_telefone1, ddd1, numero1, tipo_telefone2, ddd2, numero2, id_cliente ) "
                    + "VALUES "
                    + "(?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getTipo());
            st.setString(2, obj.getDdd());
            st.setString(3, obj.getNumero());
            st.setString(4, obj.getTipo1());
            st.setString(5, obj.getDdd1());
            st.setString(6, obj.getNumero1());
            st.setString(7, obj.getTipo2());
            st.setString(8, obj.getDdd2());
            st.setString(9, obj.getNumero2());
            st.setInt(10, obj.getCliente().getId());
                                    
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
    public void updateCliente(Telefone obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("UPDATE tb_telefone SET tipo_telefone = ?, ddd = ?, numero = ?, tipo_telefone1 = ?, ddd1 = ?, numero1 = ?, tipo_telefone2 = ?, ddd2 = ?, numero2 = ? "
                    + "WHERE id_cliente = ?");

            st.setString(1, obj.getTipo());
            st.setString(2, obj.getDdd());
            st.setString(3, obj.getNumero());
            st.setString(4, obj.getTipo1());
            st.setString(5, obj.getDdd1());
            st.setString(6, obj.getNumero1());
            st.setString(7, obj.getTipo2());
            st.setString(8, obj.getDdd2());
            st.setString(9, obj.getNumero2());
            st.setInt(10, obj.getCliente().getId());
            
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
                    + "WHERE id_cliente = ? ");

            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                Telefone obj = new Telefone();
                obj.setId(rs.getInt("id"));
                obj.setTipo(rs.getString("tipo_telefone"));
                obj.setDdd(rs.getString("ddd"));
                obj.setNumero(rs.getString("numero"));
                obj.setTipo1(rs.getString("tipo_telefone1"));
                obj.setDdd1(rs.getString("ddd1"));
                obj.setNumero1(rs.getString("numero1"));
                obj.setTipo2(rs.getString("tipo_telefone2"));
                obj.setDdd2(rs.getString("ddd2"));
                obj.setNumero2(rs.getString("numero2"));
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
                    + "ORDER BY id");

            rs = st.executeQuery();

            List<Telefone> telefones = new ArrayList<>();

            while (rs.next()) {
                Telefone obj = new Telefone();
                obj.setId(rs.getInt("id"));
                obj.setDdd(rs.getString("ddd"));
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

    @Override
    public void insertFuncionario(Telefone obj) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("INSERT INTO tb_telefone "
                    + "(tipo_telefone, ddd, numero, tipo_telefone1, ddd1, numero1, tipo_telefone2, ddd2, numero2, id_funcionario ) "
                    + "VALUES "
                    + "(?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getTipo());
            st.setString(2, obj.getDdd());
            st.setString(3, obj.getNumero());
            st.setString(4, obj.getTipo1());
            st.setString(5, obj.getDdd1());
            st.setString(6, obj.getNumero1());
            st.setString(7, obj.getTipo2());
            st.setString(8, obj.getDdd2());
            st.setString(9, obj.getNumero2());
            st.setInt(10, obj.getFuncionario().getId());
                        
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
    public void updateFuncionario(Telefone obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("UPDATE tb_telefone SET tipo_telefone = ?, ddd = ?, numero = ?, tipo_telefone1 = ?, ddd1 = ?, numero1 = ?, tipo_telefone2 = ?, ddd2 = ?, numero2 = ? "
                    + "WHERE id_funcionario = ?");

            st.setString(1, obj.getTipo());
            st.setString(2, obj.getDdd());
            st.setString(3, obj.getNumero());
            st.setString(4, obj.getTipo1());
            st.setString(5, obj.getDdd1());
            st.setString(6, obj.getNumero1());
            st.setString(7, obj.getTipo2());
            st.setString(8, obj.getDdd2());
            st.setString(9, obj.getNumero2());
            st.setInt(10, obj.getCliente().getId());
            
            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException("Erro: " + e.getMessage());
        } finally {
            Db.closeStatement(st);
        }
    }
}
