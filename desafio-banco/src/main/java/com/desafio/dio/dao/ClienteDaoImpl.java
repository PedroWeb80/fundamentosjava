package com.desafio.dio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.desafio.dio.contracts.ClienteDao;
import com.desafio.dio.models.Cliente;

public class ClienteDaoImpl implements ClienteDao {
    private Connection conn;

    public ClienteDaoImpl(Connection conn) {
        this.conn = DbConnection.getConnection();
    }

    @Override
    public List<Cliente> getAll() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM clientes");

            while (result.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(result.getLong("id"));
                cliente.setNome(result.getString("nome"));
                cliente.setIdade(result.getInt("idade"));
                cliente.setEndereco(result.getString("endereco"));

                clientes.add(cliente);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return clientes;
    }

    @Override
    public Cliente getById(Long id) {
        Cliente cliente = new Cliente();
        try {

            PreparedStatement statement = conn.prepareStatement("SELECT * FROM clientes WHERE id = ?");
            statement.setLong(1, id);

            ResultSet result = statement.executeQuery();
            
            if(!result.next()) {
                return null;
            }

            cliente.setId(result.getLong("id"));
            cliente.setNome(result.getString("nome"));
            cliente.setIdade(result.getInt("idade"));
            cliente.setEndereco(result.getString("endereco"));
            cliente.setContato(result.getString("contato"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }

    @Override
    public void delete(Cliente cliente) {
        String sql = "DELETE FROM clientes WHERE id = ?";
        try {
            PreparedStatement prepareStatement = conn.prepareStatement(sql);
            prepareStatement.setLong(1, cliente.getId());
            prepareStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Cliente cliente) {

        String sql = "UPDATE clientes SET nome = ?, idade = ?, endereco = ?, contato = ?, cpf = ? WHERE id = ?";
        try {
            PreparedStatement prepareStatement = conn.prepareStatement(sql);
            prepareStatement.setString(1, cliente.getNome());
            prepareStatement.setInt(2, cliente.getIdade());
            prepareStatement.setString(3, cliente.getEndereco());
            prepareStatement.setString(4, cliente.getContato());
            prepareStatement.setString(5, cliente.getCpf());
            prepareStatement.setLong(6, cliente.getId());

            prepareStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public Cliente create(Cliente cliente) {
        String sql = "INSERT INTO clientes (nome, idade, endereco, contato, cpf) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, cliente.getNome());
            statement.setInt(2, cliente.getIdade());
            statement.setString(3, cliente.getEndereco());
            statement.setString(4, cliente.getContato());
            statement.setString(5, cliente.getCpf());

            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return cliente;
    }

    @Override
    public Cliente getByCpf(String cpf) {
        Cliente cliente = new Cliente();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM clientes WHERE cpf = ?");
            preparedStatement.setString(1, cpf);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if(!resultSet.next()) {
                throw new NullPointerException("Cliente não encontrado");
            }

            cliente.setNome(resultSet.getString("nome"));
            cliente.setIdade(resultSet.getInt("idade"));
            cliente.setContato(resultSet.getString("contato"));
            cliente.setEndereco(resultSet.getString("endereco"));
            cliente.setCpf(resultSet.getString("cpf"));
            cliente.setId(resultSet.getLong("id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }

}
