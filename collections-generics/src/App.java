import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<ComparableLivro> livros = new ArrayList<>();
        
        ComparableLivro livro = new ComparableLivro();
        livro.setIsbn(1254);
        livro.setName("zé do mundo");
        livro.setCreatedAt(new Date());

        ComparableLivro livro2 = new ComparableLivro();
        livro2.setIsbn(254);
        livro2.setName("Luz do mundo");
        livro2.setCreatedAt(new Date());
        
        livros.add(livro);
        livros.add(livro2);

        Collections.sort(livros, new IsbnComparator());

        livros.forEach(l -> {
            System.out.println(l.getName());
            System.out.println(l.getIsbn());
        });

    }
}
