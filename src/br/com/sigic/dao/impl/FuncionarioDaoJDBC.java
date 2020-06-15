/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigic.dao.impl;

import br.com.sigic.model.Funcionario;

import java.sql.*;
import br.com.sigic.db.Db;
import br.com.sigic.db.DbException;
import br.com.sigic.dao.FuncionarioDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ederc
 */
public class FuncionarioDaoJDBC implements FuncionarioDao {

    public FuncionarioDaoJDBC() {
    }

    private Connection conn;

    public FuncionarioDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Funcionario obj) {

        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("INSERT INTO tb_pessoa"
                    + "(nome, email, cpf, data_nascimento)"
                    + "VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getNome());
            st.setString(2, obj.getEmail());
            st.setString(3, obj.getCpf());
            st.setString(4, Db.sendDateToMySql(obj.getNascimento()));

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
    public void update(Funcionario obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("UPDATE tb_pessoa SET nome = ?, email = ?, cpf = ?, data_nascimento = ? WHERE Id = ?");

            st.setString(1, obj.getNome());
            st.setString(2, obj.getEmail());
            st.setString(3, obj.getCpf());
            st.setString(4, Db.sendDateToMySql(obj.getNascimento()));
            st.setInt(5, obj.getId());

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
            st = conn.prepareStatement("DELETE FROM tb_pessoa WHERE id = ?");

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
    public Funcionario findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * "
                    + "FROM tb_pessoa "
                    + "WHERE id = ? "
                    + "AND id_categoria = 2");

            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                Funcionario obj = new Funcionario();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setEmail(rs.getString("email"));
                obj.setCpf(rs.getString("cpf"));
                obj.setNascimento(rs.getDate("data_nascimento"));
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
    public List<Funcionario> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {

            st = conn.prepareStatement("SELECT * FROM tb_pessoa WHERE id_categoria = 1 ORDER BY Nome");

            rs = st.executeQuery();

            List<Funcionario> funcionarios = new ArrayList<>();

            while (rs.next()) {
                Funcionario obj = new Funcionario();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setEmail(rs.getString("email"));
                obj.setCpf(rs.getString("cpf"));
                obj.setNascimento(rs.getDate("data_nascimento"));
                funcionarios.add(obj);
            }
            return funcionarios;
        } catch (SQLException erro) {
            throw new DbException(erro.getMessage());
        } finally {
            Db.closeStatement(st);
            Db.closeResultSet(rs);
        }
    }
}
