package com.desafio.dio.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@EqualsAndHashCode
@Data
public class Cliente {

	private Long id;

	private String nome;

	private int idade;

	private String endereco;

	private String contato;

	private String cpf;

	public Cliente(String nome, int idade, String endereco, String contato, String cpf) {
		this.nome = nome;
		this.idade = idade;
		this.endereco = endereco;
		this.contato = contato;
		this.cpf = cpf;
	}
}
