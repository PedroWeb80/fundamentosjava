package com.desafio.dio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.desafio.dio.contracts.ContaCorrenteDao;
import com.desafio.dio.models.Banco;
import com.desafio.dio.models.Cliente;
import com.desafio.dio.models.ContaCorrente;
import com.desafio.dio.services.BancoService;
import com.desafio.dio.services.ClienteService;

public class ContaCorrenteDaoImpl implements ContaCorrenteDao {
    private Connection conn;
    private ClienteService clienteService;
    private BancoService bancoService;

    public ContaCorrenteDaoImpl(Connection conn) {
        this.conn = DbConnection.getConnection();
        this.clienteService = new ClienteService(conn);
        this.bancoService = new BancoService(conn);
    }

    @Override
    public List<ContaCorrente> getAll() {
        List<ContaCorrente> contasCorrente = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM contas_corrente");

            while (result.next()) {
                Cliente cliente = this.clienteService.getCliente(result.getLong("cliente"));
                Banco banco = this.bancoService.getBanco(result.getLong("banco"));

                ContaCorrente contaCorrente = new ContaCorrente(cliente, banco);

                contaCorrente.setId(result.getLong("id"));
                contaCorrente.setAgencia(result.getInt("agencia"));
                contaCorrente.setNumero(result.getInt("numero"));
                contaCorrente.setSaldo(result.getDouble("saldo"));
                contaCorrente.setBanco(banco);
                contaCorrente.setCliente(cliente);

                contasCorrente.add(contaCorrente);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return contasCorrente;
    }

    @Override
    public ContaCorrente getById(Long id) {
        ContaCorrente contaCorrente = null;
        try {

            PreparedStatement statement = conn.prepareStatement("SELECT * FROM contas_corrente WHERE id = ?");
            statement.setLong(1, id);

            ResultSet result = statement.executeQuery();

            if (!result.next()) {
                return null;
            }

            Cliente cliente = this.clienteService.getCliente(result.getLong("cliente"));
            Banco banco = this.bancoService.getBanco(result.getLong("banco"));
            contaCorrente = new ContaCorrente(cliente, banco);
            contaCorrente.setSaldo(result.getDouble("saldo"));
            contaCorrente.setNumero(result.getInt("numero"));
            contaCorrente.setAgencia(result.getInt("agencia"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contaCorrente;
    }

    @Override
    public void delete(ContaCorrente ContaCorrente) {
        String sql = "DELETE FROM contas_corrente WHERE id = ?";
        try {
            PreparedStatement prepareStatement = conn.prepareStatement(sql);
            prepareStatement.setLong(1, ContaCorrente.getId());
            prepareStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(ContaCorrente ContaCorrente) {

        String sql = "UPDATE SET contas_corrente numero = ?, agencia = ?, saldo = ?, banco = ? WHERE id = ?";
        try {
            PreparedStatement prepareStatement = conn.prepareStatement(sql);
            prepareStatement.setInt(1, ContaCorrente.getNumero());
            prepareStatement.setDouble(2, ContaCorrente.getAgencia());
            prepareStatement.setDouble(3, ContaCorrente.getSaldo());
            prepareStatement.setLong(4, ContaCorrente.getBanco().getId());

            prepareStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public ContaCorrente create(ContaCorrente ContaCorrente) {
        String sql = "INSERT INTO contas_corrente (agencia, numero, saldo, cliente, banco) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setDouble(1, ContaCorrente.getAgencia());
            statement.setDouble(2, ContaCorrente.getNumero());
            statement.setDouble(3, ContaCorrente.getSaldo());
            statement.setLong(4, ContaCorrente.getCliente().getId());
            statement.setLong(5, ContaCorrente.getBanco().getId());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return ContaCorrente;
    }

    @Override
    public ContaCorrente getByNumero(int numero) {
        ContaCorrente contaCorrente = null;
        try {

            PreparedStatement statement = conn.prepareStatement("SELECT * FROM contas_corrente WHERE id = ?");
            statement.setLong(1, numero);

            ResultSet result = statement.executeQuery();

            if (!result.next()) {
                return null;
            }

            Cliente cliente = this.clienteService.getCliente(result.getLong("cliente"));
            Banco banco = this.bancoService.getBanco(result.getLong("banco"));
            contaCorrente = new ContaCorrente(cliente, banco);
            contaCorrente.setSaldo(result.getDouble("saldo"));
            contaCorrente.setNumero(result.getInt("numero"));
            contaCorrente.setAgencia(result.getInt("agencia"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contaCorrente;
    }

}
