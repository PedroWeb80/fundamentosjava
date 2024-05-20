package com.desafio.dio.contracts;

import java.util.List;

import com.desafio.dio.models.Cliente;

public interface ClienteDao {
    public List<Cliente> getAll();
    public Cliente getById(Long id);
    public void delete(Cliente cliente);
    public void update(Cliente cliente);
    public Cliente create(Cliente cliente);
    public Cliente getByCpf(String cpf);
}
