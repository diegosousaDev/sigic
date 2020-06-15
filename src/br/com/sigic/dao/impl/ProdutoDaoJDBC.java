/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigic.dao.impl;

import br.com.sigic.model.Produto;

import java.sql.*;
import br.com.sigic.db.Db;
import br.com.sigic.db.DbException;
import br.com.sigic.dao.ProdutoDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ederc
 */
public class ProdutoDaoJDBC implements ProdutoDao {

    public ProdutoDaoJDBC() {
    }

    private Connection conn;

    public ProdutoDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Produto obj) {

        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("INSERT INTO tb_produto"
                    + "(nome, descricao, preco, imgUrl)"
                    + "VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getNome());
            st.setString(2, obj.getDescricao());
            st.setDouble(3, obj.getPreco());
            st.setString(4, obj.getImgUrl());
            
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
    public void update(Produto obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("UPDATE tb_produto SET nome = ?, descricao = ?, preco = ?, imgUrl = ? "
                    + "WHERE Id = ?");

            st.setString(1, obj.getNome());
            st.setString(2, obj.getDescricao());
            st.setDouble(3, obj.getPreco());
            st.setString(4, obj.getImgUrl());
            st.setInt(5, obj.getId());

            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException("Erro: " + e.getMessage());
        } finally {
            Db.closeStatement(st);
        }
    }

    @Override
    public Produto findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * "
                    + "FROM tb_produto "
                    + "WHERE id = ? ");

            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                Produto obj = instanciarProduto(rs);                              
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
    public List<Produto> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {

            st = conn.prepareStatement("SELECT * FROM tb_produto "
                    + "ORDER BY nome");

            rs = st.executeQuery();

            List<Produto> produtos = new ArrayList<>();

            while (rs.next()) {
                Produto obj = instanciarProduto(rs);                          
                produtos.add(obj);
            }
            return produtos;
        } catch (SQLException erro) {
            throw new DbException(erro.getMessage());
        } finally {
            Db.closeStatement(st);
            Db.closeResultSet(rs);
        }
    }
    private Produto instanciarProduto(ResultSet rs) throws SQLException{
        Produto obj = new Produto();
        obj.setId(rs.getInt("id"));
        obj.setNome(rs.getString("nome"));
        obj.setDescricao(rs.getString("descricao"));
        obj.setPreco(rs.getDouble("preco"));
        obj.setImgUrl(rs.getString("imgUrl"));
        return obj;
        
    }
}
