package com.desafio.dio.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.desafio.dio.contracts.BancoDao;
import com.desafio.dio.models.Banco;

public class BancoDaoImpl implements BancoDao {
    private Connection conn;

    public BancoDaoImpl(Connection conn) {
        this.conn = DbConnection.getConnection();
    }

    @Override
    public List<Banco> getAll() {
        List<Banco> bancos = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM bancos");

            while (result.next()) {
                Banco banco = new Banco();
                banco.setId(result.getLong("id"));
                banco.setNome(result.getString("nome"));

                bancos.add(banco);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return bancos;
    }

    @Override
    public Banco getById(Long id) {
        Banco banco = new Banco();
        try {

            PreparedStatement statement = conn.prepareStatement("SELECT * FROM bancos WHERE ID = ?");
            statement.setLong(1, id);

            ResultSet result = statement.executeQuery();
            if(!result.next()){
                return null;
            }
            banco.setId(result.getLong("id"));
            banco.setNome(result.getString("nome"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return banco;
    }

    @Override
    public void delete(Banco banco) {
        String sql = "DELETE FROM bancos WHERE id = ?";
        try {
            PreparedStatement prepareStatement = conn.prepareStatement(sql);
            prepareStatement.setLong(1, banco.getId());
            prepareStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Banco banco) {

        String sql = "UPDATE SET bancos nome = ? WHERE id = ?";
        try {
            PreparedStatement prepareStatement = conn.prepareStatement(sql);
            prepareStatement.setString(1, banco.getNome());

            prepareStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public Banco create(Banco banco) {
        String sql = "INSERT INTO bancos (nome) VALUES (?)";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, banco.getNome().toLowerCase());

            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return banco;
    }

    @Override
    public Banco getByNome(String nome) {
        Banco banco = new Banco();
        try {

            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM bancos WHERE nome = ?");
            preparedStatement.setString(1, nome.toLowerCase());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) {
                return null;
            }

            banco.setId(resultSet.getLong("id"));
            banco.setNome(nome);

        }
 
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return banco;
    }

}
