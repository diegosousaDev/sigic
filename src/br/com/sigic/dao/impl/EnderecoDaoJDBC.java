/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigic.dao.impl;

import java.sql.*;
import br.com.sigic.db.Db;
import br.com.sigic.db.DbException;
import br.com.sigic.dao.EnderecoDao;
import br.com.sigic.model.Endereco;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ederc
 */
public class EnderecoDaoJDBC implements EnderecoDao {

    public EnderecoDaoJDBC() {
    }

    private Connection conn;

    public EnderecoDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Endereco obj) {

        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("INSERT INTO tb_endereco"
                    + "(logradouro, rua, numero, complemento, bairro, cidade, uf, cep)"
                    + "VALUES (?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getLogradouro());
            st.setString(2, obj.getRua());
            st.setInt(3, obj.getNumero());
            st.setString(4, obj.getComplemento());
            st.setString(5, obj.getBairro());
            st.setString(6, obj.getCidade());
            st.setString(7, obj.getEstado());
            st.setString(8, obj.getCep());
            
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
    public void update(Endereco obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("UPDATE tb_endereco "
                    + "SET logradouro = ?, rua = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, uf = ?, cep = ? "
                    + "WHERE Id = ?");

            st.setString(1, obj.getLogradouro());
            st.setString(2, obj.getRua());
            st.setInt(3, obj.getNumero());
            st.setString(4, obj.getComplemento());
            st.setString(5, obj.getBairro());
            st.setString(6, obj.getCidade());
            st.setString(7, obj.getEstado());
            st.setString(8, obj.getCep());
            st.setInt(9, obj.getId());

            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException("Erro: " + e.getMessage());
        } finally {
            Db.closeStatement(st);
        }
    }

    @Override
    public void deleteById(Integer id) {

        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("DELETE FROM tb_endereco "
                    + "WHERE id = ?");

            st.setInt(1, id);

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
    public Endereco findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * "
                    + "FROM tb_endereco "
                    + "WHERE id = ? ");

            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                Endereco obj = instanciarEndereco(rs);
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
    public List<Endereco> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {

            st = conn.prepareStatement("SELECT * "
                    + "FROM tb_endereco "
                    + "ORDER BY Nome");

            rs = st.executeQuery();

            List<Endereco> enderecos = new ArrayList<>();

            while (rs.next()) {
                Endereco obj = instanciarEndereco(rs);
                enderecos.add(obj);
            }
            return enderecos;
        } catch (SQLException erro) {
            throw new DbException(erro.getMessage());
        } finally {
            Db.closeStatement(st);
            Db.closeResultSet(rs);
        }
    }
    private Endereco instanciarEndereco(ResultSet rs) throws SQLException{
        Endereco obj = new Endereco();
        obj.setId(rs.getInt("id"));
        obj.setLogradouro(rs.getString("logradouro"));
        obj.setRua(rs.getString("rua"));
        obj.setNumero(rs.getInt("numero"));
        obj.setComplemento(rs.getString("complemento"));
        obj.setBairro(rs.getString("bairro"));
        obj.setCidade(rs.getString("uf"));
        obj.setCep(rs.getString("cep"));
        return obj;
    }
}
