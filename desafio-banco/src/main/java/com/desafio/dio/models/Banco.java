package com.desafio.dio.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Banco {
	@Getter
	@Setter
	private Long id;

	@Getter
	@Setter
	private String nome;
	private List<Conta> contas = new ArrayList<>();

	public Banco(String nome) {
		this.nome = nome;
	}
	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(Conta conta) {
		this.contas.add(conta);
	}

	public int getQuantidadeContas() {
		return this.contas.size();
	}

}
