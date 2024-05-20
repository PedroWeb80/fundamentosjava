package com.desafio.dio;

import java.sql.Connection;
import java.util.Scanner;

import com.desafio.dio.contracts.IConta;
import com.desafio.dio.dao.DbConnection;
import com.desafio.dio.models.Banco;
import com.desafio.dio.models.Cliente;
import com.desafio.dio.models.ContaCorrente;
import com.desafio.dio.models.ContaPoupanca;
import com.desafio.dio.services.BancoService;
import com.desafio.dio.services.ClienteService;
import com.desafio.dio.services.ContaCorrenteService;
import com.desafio.dio.services.ContaPoupancaService;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Connection conn = DbConnection.getConnection();
        BancoService bancoService = new BancoService(conn);
        ClienteService clienteService = new ClienteService(conn);
        ContaCorrenteService ccService = new ContaCorrenteService(conn);
        ContaPoupancaService cpService = new ContaPoupancaService(conn);
        while (true) {
            try {

                inicio(bancoService, clienteService, ccService, cpService);

            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Pressione qualqer tecla para continuar.....");
                sc.nextLine();
            }
        }
    }

    private static void inicio(
            BancoService bancoService,
            ClienteService clienteService,
            ContaCorrenteService ccService,
            ContaPoupancaService cpService) {

        System.out.println("=====================================");
        System.out.println("Bem vindo ao nosso sistema cadastro de contas");
        System.out.println("=====================================");
        System.err.println("Presione qualquer tecla para continuar");
        sc.nextLine();

        createBancoIfNotExists(bancoService);
        createClienteIfNotExists(clienteService);

        System.out.println("Escolha uma opção:");
        System.out.println("1-Cadastrar banco");
        System.out.println("2-Cadastrar cliente");
        System.out.println("3-Cadastrar conta");
        System.out.println("4-Listar bancos");
        System.out.println("5-Listar clientes");
        System.out.println("6-Listar contas");
        System.out.println("7-Sair do sistema");

        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1:
                if (bancoService.createBanco(makeBanco()) != null)
                    System.out.println("banco cadastrado.");
                else
                    System.out.println("erro ao cadastar banco");

                break;
            case 2:
                if (clienteService.createCliente(makeCliente()) != null)
                    System.out.println("Cliente cadastrado.");
                else
                    System.out.println("erro ao cadastrar cliente tente");
                break;
            case 3:
                IConta conta = null;
                System.out.println("escolha o tipo da conta:");
                System.out.println("1-Conta Corrente");
                System.out.println("2-Conta Poupança");
                String tipo = sc.nextLine();
                if (tipo.equals("1")) {
                    conta = makeContaCorrente(clienteService, bancoService);
                    if (ccService.createContaCorrente((ContaCorrente) conta) != null) {
                        System.out.println("Conta cadastrada");
                        sc.nextLine();
                    } else {
                        System.out.println("Erro ao cadastrar conta");
                    }
                } else if (tipo.equals("2")) {
                    conta = makeContaPoupanca(clienteService, bancoService);
                    if (cpService.createContaPoupanca((ContaPoupanca) conta) != null) {
                        System.out.println("Conta cadastrada");
                        sc.nextLine();
                    } else {
                        System.out.println("Erro ao cadastrar conta");
                    }
                }
                break;
            case 4:
                System.out.println("========Lista de Bancos=======");
                bancoService.getBancos().forEach(banco -> {
                    System.out.println(banco.getNome());
                    System.out.println("Quantidade de contas " + banco.getQuantidadeContas());
                });
                break;
            case 5:
                System.out.println("========Lista de Clientes=======");
                clienteService.getClientes().forEach(cliente -> {
                    System.out.println(cliente.getNome());
                });
                System.out.println("Quantidade de clientes " + clienteService.getClientes().size());
                System.out.println();
                break;
            case 6:
                System.out.println("========Lista de Contas=======");
                System.out.println("------Contas Corrente-----");
                ccService.getContaCorrentes().forEach(c -> {
                    System.out.println("Agencia: " + c.getAgencia());
                    System.out.println("Numero: " + c.getNumero());
                    System.out.println("Cliente: " + c.getCliente().getNome());
                    System.out.printf("Saldo: R$%.2f", c.getSaldo());
                    System.out.println();
                    System.out.println();

                });
                System.out.println("------Contas Poupança-----");
                cpService.getContaPoupancas().forEach(c -> {
                    System.out.println("Agencia: " + c.getAgencia());
                    System.out.println("Numero: " + c.getNumero());
                    System.out.println("Cliente: " + c.getCliente().getNome());
                    System.out.printf("Saldo: R$%.2f", c.getSaldo());
                    System.out.println();
                    System.out.println();

                });
                break;
            case 8:
                System.out.println("7- sair do sistema");
                break;
            default:
                System.out.println("escolha uma opção valida....");
                break;
        }
    }

    private static void createBancoIfNotExists(BancoService banco) {
        System.out.println("Antes de começar cadastre um banco e um cliente ");
        if (banco.getBancos().isEmpty()) {
            banco.createBanco(makeBanco());
        }
    }

    private static void createClienteIfNotExists(ClienteService cliente) {
        if (cliente.getClientes().isEmpty()) {

            cliente.createCliente(makeCliente());
        }
    }

    private static Cliente makeCliente() {
        System.out.println("Cadastre um cliente:");

        System.out.println("Digite o nome do cliente");
        String nome = sc.nextLine();

        System.out.println("Digite o idade do cliente");
        int idade = sc.nextInt();
        sc.nextLine();

        System.out.println("Digite o endereço do cliente");
        String endereco = sc.nextLine();

        System.out.println("Digite o contato do cliente");
        String contato = sc.nextLine();

        System.out.println("Digite o cpf do cliente");
        String cpf = sc.nextLine();

        return new Cliente(nome, idade, endereco, contato, cpf);
    }

    private static Banco makeBanco() {
        System.out.println("Digite o nome do banco");
        String nome = sc.nextLine();
        return new Banco(nome);
    }

    private static ContaCorrente makeContaCorrente(ClienteService clienteService, BancoService bancoService) {
        ContaCorrente cc = null;

        System.out.println("Digite o saldo inicial");

        double saldo = sc.nextDouble();
        sc.nextLine();

        System.out.println("Digite o cpf do cliente");
        String cpf = sc.nextLine();
        Cliente cliente = clienteService.getClienteByCpf(cpf);

        System.out.println("Digite o nome do banco");
        String nomeBanco = sc.nextLine();
        Banco banco = bancoService.getByNome(nomeBanco);

        cc = new ContaCorrente(cliente, banco);

        cc.setSaldo(saldo);
        return cc;
    }

    private static ContaPoupanca makeContaPoupanca(ClienteService clienteService, BancoService bancoService) {
        ContaPoupanca cp = null;

        System.out.println("Digite o saldo inicial");

        double saldo = sc.nextDouble();
        sc.nextLine();

        System.out.println("Digite o cpf do cliente");
        String cpf = sc.nextLine();
        Cliente cliente = clienteService.getClienteByCpf(cpf);

        System.out.println("Digite o nome do banco");
        String nomeBanco = sc.nextLine();
        Banco banco = bancoService.getByNome(nomeBanco);

        cp = new ContaPoupanca(cliente, banco);

        cp.setSaldo(saldo);
        return cp;
    }

}