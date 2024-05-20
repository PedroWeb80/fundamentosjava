package com.desafio.dio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.desafio.dio.contracts.ContaPoupancaDao;
import com.desafio.dio.models.Banco;
import com.desafio.dio.models.Cliente;
import com.desafio.dio.models.ContaPoupanca;
import com.desafio.dio.services.BancoService;
import com.desafio.dio.services.ClienteService;

public class ContaPoupancaDaoImpl implements ContaPoupancaDao {
    private Connection conn;
    private ClienteService clienteService;
    private BancoService bancoService;

    public ContaPoupancaDaoImpl(Connection conn) {
        this.conn = DbConnection.getConnection();
        this.clienteService = new ClienteService(conn);
        this.bancoService = new BancoService(conn);
    }

    @Override
    public List<ContaPoupanca> getAll() {
        List<ContaPoupanca> contasCorrente = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM contas_poupanca");

            while (result.next()) {
                Cliente cliente = this.clienteService.getCliente(result.getLong("cliente"));
                Banco banco = this.bancoService.getBanco(result.getLong("banco"));
                ContaPoupanca contaCorrente = new ContaPoupanca(cliente, banco);

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
    public ContaPoupanca getById(Long id) {
        ContaPoupanca contaPoupanca = null;
        try {

            PreparedStatement statement = conn.prepareStatement("SELECT * FROM contas_poupanca WHERE id = ?");
            statement.setLong(1, id);

            ResultSet result = statement.executeQuery();

            if (!result.next()) {
                return null;
            }

            Cliente cliente = this.clienteService.getCliente(result.getLong("cliente"));
            Banco banco = this.bancoService.getBanco(result.getLong("banco"));
            contaPoupanca = new ContaPoupanca(cliente, banco);
            contaPoupanca.setSaldo(result.getDouble("saldo"));
            contaPoupanca.setNumero(result.getInt("numero"));
            contaPoupanca.setAgencia(result.getInt("agencia"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contaPoupanca;
    }

    @Override
    public void delete(ContaPoupanca contaPoupanca) {
        String sql = "DELETE FROM contas_poupanca WHERE id = ?";
        try {
            PreparedStatement prepareStatement = conn.prepareStatement(sql);
            prepareStatement.setLong(1, contaPoupanca.getId());
            prepareStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(ContaPoupanca contaPoupanca) {

        String sql = "UPDATE set contas_poupanca numero = ?, agencia = ?, saldo = ?, banco = ? WHERE id = ?";
        try {
            PreparedStatement prepareStatement = conn.prepareStatement(sql);
            prepareStatement.setInt(1, contaPoupanca.getNumero());
            prepareStatement.setDouble(2, contaPoupanca.getAgencia());
            prepareStatement.setDouble(3, contaPoupanca.getSaldo());
            prepareStatement.setDouble(3, contaPoupanca.getBanco().getId());

            prepareStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public ContaPoupanca create(ContaPoupanca contaPoupanca) {
        String sql = "INSERT INTO contas_poupanca (agencia, numero, saldo, cliente, banco) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, contaPoupanca.getAgencia());
            statement.setInt(2, contaPoupanca.getNumero());
            statement.setDouble(3, contaPoupanca.getSaldo());
            statement.setLong(4, contaPoupanca.getCliente().getId());
            statement.setLong(5, contaPoupanca.getBanco().getId());

            statement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return contaPoupanca;
    }

    @Override
    public ContaPoupanca getByNumero(int numero) {
        ContaPoupanca contaPoupanca = null;
        try {

            PreparedStatement statement = conn.prepareStatement("SELECT * FROM contas_corrente WHERE id = ?");
            statement.setLong(1, numero);

            ResultSet result = statement.executeQuery();

            if (!result.next()) {
                return null;
            }

            Cliente cliente = this.clienteService.getCliente(result.getLong("cliente"));
            Banco banco = this.bancoService.getBanco(result.getLong("banco"));
            contaPoupanca = new ContaPoupanca(cliente, banco);
            contaPoupanca.setSaldo(result.getDouble("saldo"));
            contaPoupanca.setNumero(result.getInt("numero"));
            contaPoupanca.setAgencia(result.getInt("agencia"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contaPoupanca;
    }

}
