/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigic.dao.impl;

import br.com.sigic.model.Cliente;

import java.sql.*;
import br.com.sigic.db.Db;
import br.com.sigic.db.DbException;
import br.com.sigic.dao.ClienteDao;
import br.com.sigic.model.StatusPessoa;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author ederc
 */
public class ClienteDaoJDBC implements ClienteDao {

    public ClienteDaoJDBC() {
    }

    private Connection conn;

    public ClienteDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Cliente obj) {

        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("INSERT INTO tb_cliente "
                    + "(nome, email, cpf_cnpj, data_nascimento, apelido, observacoes, id_status) "
                    + "VALUES "
                    + "(?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            
            st.setString(1, obj.getNome());
            st.setString(2, obj.getEmail());
            st.setString(3, obj.getCpf());
            st.setString(4, obj.getNascimento());
            st.setString(5, obj.getApelido());
            st.setString(6, obj.getObservacoes());
            st.setInt(7, obj.getStatus().getId());

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
            throw new DbException("Erro: " + e);
        } finally {
            Db.closeStatement(st);
        }
    }

    @Override
    public void update(Cliente obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("UPDATE tb_cliente SET nome = ?, email = ?, cpf_cnpj = ?, data_nascimento = ?, apelido = ?, observacoes = ?, id_status = ? "
                    + "WHERE Id = ?");

            st.setString(1, obj.getNome());
            st.setString(2, obj.getEmail());
            st.setString(3, obj.getCpf());
            st.setString(4, obj.getNascimento());
            st.setString(5, obj.getApelido());
            st.setString(6, obj.getObservacoes());
            st.setInt(7, obj.getStatus().getId());
            st.setInt(8, obj.getId());

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
            st = conn.prepareStatement("DELETE FROM tb_cliente WHERE id = ?");

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
    public Cliente findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * "
                    + "FROM tb_cliente "
                    + "WHERE id = ?");

            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                Cliente obj = new Cliente();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setEmail(rs.getString("email"));
                obj.setCpf(rs.getString("cpf_cnpj"));
                obj.setNascimento(rs.getString("data_nascimento"));
                obj.setApelido(rs.getString("apelido"));
                obj.setObservacoes(rs.getString("observacoes"));
                
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
    public List<Cliente> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT tb_cliente.*, tb_statuspessoa.descricao as Status "
                    + "FROM tb_cliente "
                    + "INNER JOIN tb_statuspessoa "
                    + "ON tb_cliente.id_status = tb_statuspessoa.id "
                    + "ORDER BY id");

            rs = st.executeQuery();
            
            List<Cliente> clientes = new ArrayList<>();
            Map<Integer, StatusPessoa> map = new HashMap<>();
            
            while (rs.next()) {
               
                StatusPessoa status = map.get(rs.getInt("id_status"));
               
                if(status == null){
                    status = instanciarStatusPessoa(rs);
                    map.put(rs.getInt("id_status"), status);
                }
                                
                Cliente obj = new Cliente();
                                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setEmail(rs.getString("email"));
                obj.setCpf(rs.getString("cpf_cnpj"));
                obj.setNascimento(rs.getString("data_nascimento"));
                obj.setApelido(rs.getString("apelido"));
                obj.setObservacoes(rs.getString("observacoes"));
                obj.setStatus(status);
                clientes.add(obj);
            }
            return clientes;
        } catch (SQLException erro) {
            throw new DbException(erro.getMessage());
        } finally{
            Db.closeResultSet(rs);
            Db.closeStatement(st);
        }
    }  
    
    private StatusPessoa instanciarStatusPessoa(ResultSet rs) throws SQLException{
        StatusPessoa obj = new StatusPessoa();
        obj.setId(rs.getInt("id_status"));
        obj.setDescricao(rs.getString("Status"));
        return obj;
    }
}
