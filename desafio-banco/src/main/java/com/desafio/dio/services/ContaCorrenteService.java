package com.desafio.dio.services;

import java.sql.Connection;
import java.util.List;
import java.util.Random;

import com.desafio.dio.dao.ContaCorrenteDaoImpl;
import com.desafio.dio.models.ContaCorrente;

public class ContaCorrenteService {
    private final ContaCorrenteDaoImpl dao;

    public ContaCorrenteService(Connection conn) {
        dao = new ContaCorrenteDaoImpl(conn);
    }

    public List<ContaCorrente> getContaCorrentes() {
        return dao.getAll();
    }

    public ContaCorrente createContaCorrente(ContaCorrente contaCorrente) {
        if(contaCorrente.getCliente().getId() == null || contaCorrente.getBanco().getId() == null) {
            throw new NullPointerException("Não foi possivel criar a conta verifique os dados");
        }
        if(dao.getByNumero(contaCorrente.getNumero()) != null){
            Random r = new Random();
            contaCorrente.setNumero(r.nextInt(10000) * 2);
            System.out.println("Numero gerado automaticamente");
        }
        return dao.create(contaCorrente);
    }

    public ContaCorrente getContaCorrente(Long id) {
        ContaCorrente result = dao.getById(id);
        
        if (result == null) {
            throw new NullPointerException("Conta não foi encontrada");
        }
        
        return result;
    }

    public ContaCorrente updateContaCorrente(ContaCorrente ContaCorrente) {
        if (ContaCorrente.getId() == 0) {
            throw new IllegalArgumentException("ContaCorrente ainda não existe no sistema");
        }

        dao.update(ContaCorrente);

        return ContaCorrente;
    }

    public void deleteContaCorrente(ContaCorrente ContaCorrente) {
        dao.delete(ContaCorrente);
    }
}
