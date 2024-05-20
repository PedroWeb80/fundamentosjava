package com.desafio.dio.services;

import java.sql.Connection;
import java.util.List;
import java.util.Random;

import com.desafio.dio.dao.ContaPoupancaDaoImpl;
import com.desafio.dio.models.ContaPoupanca;

public class ContaPoupancaService {
    private final ContaPoupancaDaoImpl dao;

    public ContaPoupancaService(Connection conn) {
        dao = new ContaPoupancaDaoImpl(conn);
    }

    public List<ContaPoupanca> getContaPoupancas() {
        return dao.getAll();
    }

    public ContaPoupanca createContaPoupanca(ContaPoupanca contaPoupanca) {
        if (contaPoupanca.getCliente().getId() == null || contaPoupanca.getBanco().getId() == null) {
            throw new NullPointerException("Não foi possivel criar a conta verifique os dados");
        }

        if (dao.getByNumero(contaPoupanca.getNumero()) != null) {
            Random r = new Random();
            contaPoupanca.setNumero(r.nextInt(10000,200000));
            System.out.println("Numero gerado automaticamente");
        }
        return dao.create(contaPoupanca);
    }

    public ContaPoupanca getContaPoupanca(Long id) {
        ContaPoupanca result = dao.getById(id);

        if (result == null) {
            throw new NullPointerException("Conta não foi encontrada");
        }

        return result;
    }

    public ContaPoupanca updateContaPoupanca(ContaPoupanca contaPoupanca) {
        if (contaPoupanca.getId() == 0) {
            throw new IllegalArgumentException("ContaPoupanca ainda não existe no sistema");
        }

        dao.update(contaPoupanca);

        return contaPoupanca;
    }

    public void deleteContaPoupanca(ContaPoupanca contaPoupanca) {
        dao.delete(contaPoupanca);
    }
}
