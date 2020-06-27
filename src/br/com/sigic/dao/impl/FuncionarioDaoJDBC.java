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
import br.com.sigic.model.StatusPessoa;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
            st = conn.prepareStatement("INSERT INTO tb_funcionario "
                    + "(nome, email, cpf_cnpj, data_nascimento, data_admissao, data_saida, funcao, carteira, id_status) "
                    + "VALUES "
                    + "(?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            
            st.setString(1, obj.getNome());
            st.setString(2, obj.getEmail());
            st.setString(3, obj.getCpf());
            st.setString(4, obj.getNascimento());
            st.setString(5, obj.getData_admissao());
            st.setString(6, obj.getData_saida());
            st.setString(7, obj.getFuncao());
            st.setString(8, obj.getCarteira());
            st.setInt(9, obj.getStatus().getId());

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
    public void update(Funcionario obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("UPDATE tb_funcionario SET nome = ?, email = ?, cpf_cnpj = ?, data_nascimento = ?, data_admissao = ?, data_saida = ?, funcao = ?, carteira = ?, id_status = ? "
                    + "WHERE Id = ?");

            st.setString(1, obj.getNome());
            st.setString(2, obj.getEmail());
            st.setString(3, obj.getCpf());
            st.setString(4, obj.getNascimento());
            st.setString(5, obj.getData_admissao());
            st.setString(6, obj.getData_saida());
            st.setString(7, obj.getFuncao());
            st.setString(8, obj.getCarteira());
            st.setInt(9, obj.getStatus().getId());
            st.setInt(10, obj.getId());

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
            st = conn.prepareStatement("DELETE FROM tb_funcionario WHERE id = ?");

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
                    + "FROM tb_funcionario "
                    + "WHERE id = ?");

            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                Funcionario obj = new Funcionario();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setEmail(rs.getString("email"));
                obj.setCpf(rs.getString("cpf_cnpj"));
                obj.setNascimento(rs.getString("data_nascimento"));
                obj.setData_admissao(rs.getString("data_admissao"));
                obj.setData_saida(rs.getString("data_saida"));
                obj.setFuncao(rs.getString("funcao"));
                obj.setCarteira(rs.getString("carteira"));
                                
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
            st = conn.prepareStatement("SELECT tb_funcionario.*, tb_statuspessoa.descricao as Status "
                    + "FROM tb_funcionario "
                    + "INNER JOIN tb_statuspessoa "
                    + "ON tb_funcionario.id_status = tb_statuspessoa.id "
                    + "ORDER BY id");

            rs = st.executeQuery();
            
            List<Funcionario> funcionarios = new ArrayList<>();
            Map<Integer, StatusPessoa> map = new HashMap<>();
            
            while (rs.next()) {
               
                StatusPessoa status = map.get(rs.getInt("id_status"));
               
                if(status == null){
                    status = instanciarStatusPessoa(rs);
                    map.put(rs.getInt("id_status"), status);
                }
                                
                Funcionario obj = new Funcionario();
                                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setEmail(rs.getString("email"));
                obj.setCpf(rs.getString("cpf_cnpj"));
                obj.setNascimento(rs.getString("data_nascimento"));
                obj.setData_admissao(rs.getString("data_admissao"));
                obj.setData_saida(rs.getString("data_saida"));
                obj.setFuncao(rs.getString("funcao"));
                obj.setCarteira(rs.getString("carteira"));
                obj.setStatus(status);
                funcionarios.add(obj);
            }
            return funcionarios;
        } catch (SQLException erro) {
            throw new DbException(erro.getMessage());
        } finally{
            Db.closeResultSet(rs);
            Db.closeStatement(st);
        }
    }  
    
    @Override
    public List<Funcionario> findByName(String nome) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT tb_funcionario.*, tb_statuspessoa.descricao as Status "
                    + "FROM tb_funcionario "
                    + "INNER JOIN tb_statuspessoa "
                    + "ON tb_funcionario.id_status = tb_statuspessoa.id "
                    + "WHERE nome "
                    + "LIKE ?");

            st.setString(1, nome);            
            rs = st.executeQuery();
            
            List<Funcionario> funcionarios = new ArrayList<>();
            Map<Integer, StatusPessoa> map = new HashMap<>();
            
            while (rs.next()) {
               
                StatusPessoa status = map.get(rs.getInt("id_status"));
               
                if(status == null){
                    status = instanciarStatusPessoa(rs);
                    map.put(rs.getInt("id_status"), status);
                }
                                
                Funcionario obj = new Funcionario();
                                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setEmail(rs.getString("email"));
                obj.setCpf(rs.getString("cpf_cnpj"));
                obj.setNascimento(rs.getString("data_nascimento"));
                obj.setData_admissao(rs.getString("data_admissao"));
                obj.setData_saida(rs.getString("data_saida"));
                obj.setFuncao(rs.getString("funcao"));
                obj.setCarteira(rs.getString("carteira"));
                obj.setStatus(status);
                funcionarios.add(obj);
            }
            return funcionarios;
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
