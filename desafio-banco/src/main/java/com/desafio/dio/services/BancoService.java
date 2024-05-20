package com.desafio.dio.services;

import java.sql.Connection;
import java.util.List;

import com.desafio.dio.dao.BancoDaoImpl;
import com.desafio.dio.models.Banco;

public class BancoService {
    private final BancoDaoImpl dao;

    public BancoService(Connection conn) {
        dao = new BancoDaoImpl(conn);
    }

    public List<Banco> getBancos() {
        return dao.getAll();
    }

    public Banco createBanco(Banco banco) {
        if (banco.getNome().isEmpty()) {
            throw new NullPointerException("dados do banco estão vazios..");
        }
        return dao.create(banco);
    }

    public Banco getBanco(Long id) {

        Banco result = dao.getById(id);

        if (result == null) {
            throw new NullPointerException("Nenhum banco foi encontrado.");
        }

        return result;
    }

    public Banco updateBanco(Banco banco) {
        if (banco.getId() == null || banco.getId() == 0) {
            throw new IllegalArgumentException("Não possivel fazer busca verifique os dados");
        }

        dao.update(banco);

        return banco;
    }

    public void deleteBanco(Banco banco) {
        dao.delete(banco);
    }

    public Banco getByNome(String nome) {
        if (nome.isEmpty()) {
            throw new IllegalArgumentException("Nome esta vazio.");
        }
        
        Banco banco = dao.getByNome(nome);
        
        if(banco == null) {
            throw new NullPointerException("Nenhum banco com o nome "+ nome + " foi encontrado");
        }
        
        return banco;
    }
}
