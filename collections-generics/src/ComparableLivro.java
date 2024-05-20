import java.util.Date;

/**
 * Utilizando o Comparable para comparação de objetos
 */
public class ComparableLivro implements Comparable<ComparableLivro>{
    private int isbn;
    private String name;
    private Date createdAt;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIsbn() {
        return isbn;
    }
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
    @Override
    public int compareTo(ComparableLivro l) {
        return name.compareTo(l.name);
    }

    
}
