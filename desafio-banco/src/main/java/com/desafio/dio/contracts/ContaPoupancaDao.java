package com.desafio.dio.contracts;

import java.util.List;

import com.desafio.dio.models.ContaPoupanca;

public interface ContaPoupancaDao {
    public List<ContaPoupanca> getAll();
    public ContaPoupanca getById(Long id);
    public void delete(ContaPoupanca cliente);
    public void update(ContaPoupanca cliente);
    public ContaPoupanca create(ContaPoupanca cliente);
    public ContaPoupanca getByNumero(int numero);
}
