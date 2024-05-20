package com.desafio.dio.services;

import java.sql.Connection;
import java.util.List;

import com.desafio.dio.dao.ClienteDaoImpl;
import com.desafio.dio.models.Cliente;

public class ClienteService {
    private final ClienteDaoImpl dao;

    public ClienteService(Connection conn) {
        dao = new ClienteDaoImpl(conn);
    }

    public List<Cliente> getClientes() {
        return dao.getAll();
    }

    public Cliente createCliente(Cliente cliente) {
        if (cliente.getNome().isEmpty() || cliente.getCpf().isEmpty() || cliente.getEndereco().isEmpty()) {
            throw new IllegalArgumentException("Verifique os dados do cliente");
        }
        return dao.create(cliente);
    }

    public Cliente getCliente(Long id) {

        Cliente result = dao.getById(id);
        if (result == null) {
            throw new NullPointerException("Cliente não existe");
        }
        return result;
    }

    public Cliente updateCliente(Cliente cliente) {
        if (cliente.getId() == 0) {
            throw new IllegalArgumentException("Cliente ainda não existe no sistema");
        }

        dao.update(cliente);

        return cliente;
    }

    public void deleteCliente(Cliente cliente) {
        dao.delete(cliente);
    }

    public Cliente getClienteByCpf(String cpf) {
        if (cpf.isEmpty()) {
            throw new IllegalArgumentException("O cpf está vazio");
        }

        Cliente cliente = dao.getByCpf(cpf);
        if(cliente == null) {
            throw new NullPointerException("Cliente não foi encontrado");
        }
        return cliente;

    }
}
