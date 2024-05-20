package exercicios.set.exercicio3;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProduto {
    Set<Produto> produtosSet;

    public CadastroProduto() {
        this.produtosSet = new HashSet<>();
    }

    public void adicionarProduto(long cod, String nome, double preco, int quantidade) {
        produtosSet.add(new Produto(cod, nome, preco, quantidade));
    }

    public Set<Produto> exibirProdutosPorNome() {
        Set<Produto> produtosPorNome = new TreeSet<>(produtosSet);
        return produtosPorNome;
    }

    public Set<Produto> exibirProdutosPorPreco() {
        Set<Produto> produtosPorPreco = new TreeSet<>(new ComparatorPreco());
        produtosPorPreco.addAll(produtosSet);
        return produtosPorPreco;
    }


    public static void main(String[] args) {
        CadastroProduto c = new CadastroProduto();
        c.adicionarProduto(1L, "Carregador", 10.56, 20);
        c.adicionarProduto(2L, "Alavanca", 1000.0, 201);
        c.adicionarProduto(4L, "Bolsa", 10.8, 2);
        c.adicionarProduto(5L, "Carregador Motoroa", 10.0, 2);

        System.err.println(c.exibirProdutosPorNome());
        System.out.println();
        System.out.println(c.exibirProdutosPorPreco());
    }
}
