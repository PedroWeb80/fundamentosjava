package exercicios.listas.exercicio3;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivro {
    private List<Livro> livros;

    public CatalogoLivro() {
        this.livros = new ArrayList<>();
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public List<Livro> pesquisarPorAutor(String autor) {
        List<Livro> autores = new ArrayList<Livro>();

        autores = livros.stream()
                .filter(livro -> livro.getAutor().equalsIgnoreCase(autor)).toList();

        if (autores.isEmpty()) {
            System.out.println("este autor não existe...");
            return autores;
        }

        return autores;
    }

    public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal) {
        List<Livro> livrosPorAno = new ArrayList<>();

        if (!livros.isEmpty()) {
            livrosPorAno = livros.stream()
                    .filter(livro -> livro
                            .getPublicacao() >= anoInicial && livro.getPublicacao() <= anoFinal)
                    .toList();
            return livrosPorAno;
        }
        return livrosPorAno;
    }

    public static void main(String[] args) {
        CatalogoLivro livros = new CatalogoLivro();

        livros.adicionarLivro(new Livro("Pedro Daniel", "Liderança como agir", 2021));
        livros.adicionarLivro(new Livro("Pedro Daniel", "Teoria das estrelas", 2022));
        livros.adicionarLivro(new Livro("Pedro Daniel", "Como vencer as dificuldades", 2024));
        livros.adicionarLivro(new Livro("José Ronald", "A luta pelo poder", 2010));

        System.out.println("pesquisando por autores...");
        List<Livro> autores = livros.pesquisarPorAutor("Pedro Daniel");

        System.out.println("Lista de Autores");
        System.out.printf("%-15s %20s", "|Autor|", "|Livro|");
        System.out.println("");

        autores.forEach(autor -> {
            System.out.printf("%-30s", autor.getAutor());
            System.out.printf("%s", autor.getTitulo());
            System.out.println("");
        });

        System.out.println("");
        System.out.println("Livros por intervalo de ano");
        System.out.println("");

        List<Livro> livrosPorAno = livros.pesquisarPorIntervaloAnos(2021, 2022);

        System.out.printf("%-15s %20s %40s", "|Autor|", "|Livro|", "|Publicação|");
        System.out.println("");
        livrosPorAno.forEach(livro -> {
            System.out.printf("%-30s", livro.getAutor());
            System.out.printf("%-40s", livro.getTitulo());
            System.out.printf("%s", livro.getPublicacao());
            System.out.println("");
        });
    }
}
