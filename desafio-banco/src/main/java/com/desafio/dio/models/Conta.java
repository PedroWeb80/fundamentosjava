package com.desafio.dio.models;

import java.util.Date;
import java.util.Random;

import com.desafio.dio.contracts.IConta;

import lombok.Getter;
import lombok.Setter;

public abstract class Conta implements IConta {

	private static final int AGENCIA_PADRAO = 1;
	//private static int SEQUENCIAL = 1;
	@Getter
	@Setter
	protected Long id;
	
	@Getter
	@Setter
	protected int agencia;
	
	@Getter
	@Setter
	protected int numero;
	
	@Getter
	@Setter
	protected double saldo;
	
	@Getter
	@Setter
	protected Cliente cliente;

	@Getter
	@Setter
	protected Banco banco;

	public Conta(Cliente cliente, Banco banco) {
		Random r = new Random(AGENCIA_PADRAO);
		
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = r.nextInt(100000,  200000) * (int) new Date().getTime();
		this.cliente = cliente;
		this.banco = banco;
	}

	@Override
	public void sacar(double valor) {
		if (valor > saldo) {
			throw new IllegalArgumentException("Não a saldo suficiente");
		}
		saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		if (valor <= 0) {
			throw new IllegalArgumentException("Valor deve ser maior que zero");
		}
		saldo += valor;
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}
