/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigic.aplicacao;

import br.com.sigic.dao.DaoFactory;
import br.com.sigic.dao.ClienteDao;
import br.com.sigic.dao.FuncionarioDao;
import br.com.sigic.model.Cliente;
import br.com.sigic.model.Funcionario;
import br.com.sigic.view.utils.ViaCep;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ederc
 */
public class TesteMain {

    public static void main(String[] args) {

//        ClienteDao clienteDao = DaoFactory.criarClienteDao();
//
//        Cliente cli = new Cliente();

//        cli.setNome("Emely");
//        cli.setEmail("emely@uol.com");
//        cli.setCpf("123456");
//        cli.setNascimento(new Date("25/09/1985"));
          
//      clienteDao.insert(cli);

//      clienteDao.update(cli);
//      Cliente cli2 = clienteDao.findById(1);
//      System.out.println(cli2);
//      clienteDao.deleteById(6);
//      cli = clienteDao.findById(1);
//      System.out.println(cli);

//      clienteDao.deleteById(11);

//      List<Cliente> clientes = new ArrayList<>();
        
//      System.out.println(clienteDao.findById(3));

//        List<Cliente> clientes = new ArrayList<>();
//        for(Cliente cliente : clienteDao.findAll()){
//            System.out.println(cliente);
//        }

//        cli = clienteDao.findById(2);
//        cli.setNome("Igor");
//        cli.setEmail("igor@uol.com");
//        clienteDao.update(cli);

//        FuncionarioDao funcionarioDao = DaoFactory.criarFuncionarioDao();
//
//        Funcionario func = new Funcionario();
//
//        func.setNome("Rafael");
//        func.setEmail("rafa@gmail.com");
//        func.setCpf("7777777");
//        func.setNascimento(new Date("01/02/1970"));
//        
//        funcionarioDao.insert(func);


          ViaCep viaCep = new ViaCep();
          
          viaCep.buscarCep("83407730");
          System.out.println(viaCep.getLogradouro());
          System.out.println(viaCep.getBairro());
                  

    }
}
