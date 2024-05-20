package com.desafio.dio.contracts;

import java.util.List;

import com.desafio.dio.models.Banco;

public interface BancoDao {
    public List<Banco> getAll();
    public Banco getById(Long id);
    public void delete(Banco banco);
    public void update(Banco banco);
    public Banco create(Banco banco);
    public Banco getByNome(String nome);
}
