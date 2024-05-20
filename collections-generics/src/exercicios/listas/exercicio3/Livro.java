package exercicios.listas.exercicio3;

public class Livro {
    private String autor;
    private String titulo;
    private int publicacao;

    public Livro(String autor, String titulo, int publicacao) {
        this.autor = autor;
        this.titulo = titulo;
        this.publicacao = publicacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(int publicacao) {
        this.publicacao = publicacao;
    }

    
}
