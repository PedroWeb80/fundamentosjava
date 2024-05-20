package com.desafio.dio.contracts;

import java.util.List;

import com.desafio.dio.models.ContaCorrente;

public interface ContaCorrenteDao {
    public List<ContaCorrente> getAll();
    public ContaCorrente getById(Long id);
    public void delete(ContaCorrente contaCorrente);
    public void update(ContaCorrente contaCorrente);
    public ContaCorrente create(ContaCorrente cliente);
    public ContaCorrente getByNumero(int numero);
}
