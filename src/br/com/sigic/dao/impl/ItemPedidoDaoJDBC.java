/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package br.com.sigic.dao.impl;
//
//import br.com.sigic.model.ItemPedido;
//
//import java.sql.*;
//import br.com.sigic.db.Db;
//import br.com.sigic.db.DbException;
//import br.com.sigic.dao.ItemPedidoDao;
//import java.util.ArrayList;
//import java.util.List;

/**
 *
 * @author ederc
 */
//public class ItemPedidoDaoJDBC implements ItemPedidoDao{

//    public ItemPedidoDaoJDBC() {
//    }
//
//    private Connection conn;
//
//    public ItemPedidoDaoJDBC(Connection conn) {
//        this.conn = conn;
//    }
//
//    @Override
//    public void insert(ItemPedido obj) {
//
//        PreparedStatement st = null;
//
//        try {
//            st = conn.prepareStatement("INSERT INTO tb_pedido"
//                    + "(quantidade, preco, desconto)"
//                    + "VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
//
//            st.setInt(1, obj.getQuantidade());
//            st.setDouble(2, obj.getPreco());
//            st.setDouble(3, obj.getDesconto());
//            
//            int rowsAffected = st.executeUpdate();
//
//            if (rowsAffected > 0) {
//                ResultSet rs = st.getGeneratedKeys();
//                if (rs.next()) {
//                    int id = rs.getInt(1);
//                    obj.setId(id);
//                    Db.closeResultSet(rs);
//                } else {
//                    throw new DbException("Erro inesperado, nenhuma linha foi alterada.");
//                }
//            }
//        } catch (SQLException e) {
//            throw new DbException("Erro: " + e.getMessage());
//        } finally {
//            Db.closeStatement(st);
//        }
//    }
//
//    @Override
//    public void update(Pedido obj) {
//        PreparedStatement st = null;
//        try {
//            st = conn.prepareStatement("UPDATE tb_pedido SET data = ?, statusPedido = ?, observacao = ? "
//                    + "WHERE Id = ?");
//
//            st.setString(1, Db.sendDateToMySql(obj.getData()));
//            st.setString(2, String.valueOf(obj.getStatusPedido()));
//            st.setString(3, obj.getObservacao());
//            st.setInt(4, obj.getId());
//
//            st.executeUpdate();
//
//        } catch (SQLException e) {
//            throw new DbException("Erro: " + e.getMessage());
//        } finally {
//            Db.closeStatement(st);
//        }
//    }
//
//    @Override
//    public Pedido findById(Integer id) {
//        PreparedStatement st = null;
//        ResultSet rs = null;
//        try {
//            st = conn.prepareStatement("SELECT * "
//                    + "FROM tb_pedido "
//                    + "WHERE id = ? ");
//
//            st.setInt(1, id);
//            rs = st.executeQuery();
//
//            if (rs.next()) {
//                Pedido obj = new Pedido();
//                obj.setId(rs.getInt("id"));
//                obj.setData(rs.getDate("data"));
//                obj.setStatusPedido(StatusPedido.valueOf(rs.getString("statusPedido")));
//                obj.setObservacao(rs.getString("observacao"));
//                               
//                return obj;
//            }
//            return null;
//        } catch (SQLException erro) {
//            throw new DbException(erro.getMessage());
//        } finally {
//            Db.closeStatement(st);
//            Db.closeResultSet(rs);
//        }
//    }
//
//    @Override
//    public List<Pedido> findAll() {
//        PreparedStatement st = null;
//        ResultSet rs = null;
//        try {
//
//            st = conn.prepareStatement("SELECT * FROM tb_pedido ORDER BY data");
//
//            rs = st.executeQuery();
//
//            List<Pedido> clientes = new ArrayList<>();
//
//            while (rs.next()) {
//                Pedido obj = new Pedido();
//                obj.setId(rs.getInt("id"));
//                obj.setData(rs.getDate("data"));
//                obj.setStatusPedido(StatusPedido.valueOf(rs.getString("statusPedido")));
//                obj.setObservacao(rs.getString("observacao"));
//                               
//                clientes.add(obj);
//            }
//            return clientes;
//        } catch (SQLException erro) {
//            throw new DbException(erro.getMessage());
//        } finally {
//            Db.closeStatement(st);
//            Db.closeResultSet(rs);
//        }
//    }
//}
