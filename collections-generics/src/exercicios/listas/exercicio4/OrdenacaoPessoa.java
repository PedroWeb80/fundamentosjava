package exercicios.listas.exercicio4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoa {
    List<Pessoa> pessoas;

    
    public OrdenacaoPessoa() {
        this.pessoas = new ArrayList<Pessoa>();
    }

    public void adicionarPessoa(String nome, int idade, double altura) {
        pessoas.add(new Pessoa(nome, idade, altura));
    }

    public List<Pessoa> ordenarPorIdade() {
        List<Pessoa> pessoaPorIdade = new ArrayList<>(pessoas);
        Collections.sort(pessoaPorIdade);
        return pessoaPorIdade;
    }
    public List<Pessoa> ordenarPorAltura() {
        List<Pessoa> pessoaPorAltura = new ArrayList<>(pessoas);
        Collections.sort(pessoaPorAltura, new PessoaAlturaComparator());

        return pessoaPorAltura;
    }
    public static void main(String[] args) {
        OrdenacaoPessoa ordenacaoPessoa = new OrdenacaoPessoa();
        ordenacaoPessoa.adicionarPessoa("pedro", 10, 1.10);
        ordenacaoPessoa.adicionarPessoa("elias", 20, 1.80);
        ordenacaoPessoa.adicionarPessoa("karina", 5, 1.20);

        ordenacaoPessoa.ordenarPorIdade().forEach(pessoa -> System.out.println(pessoa.getIdade()));

        ordenacaoPessoa.ordenarPorAltura().forEach(pessoa -> System.out.println(pessoa.getAltura()));
    }
}
