import java.util.Comparator;

public class IsbnComparator implements Comparator<ComparableLivro>{

    @Override
    public int compare(ComparableLivro o1, ComparableLivro o2) {
        if(o1.getIsbn() < o2.getIsbn()) {
            return 1;
        }
        else {
            return -1;
        }
    }

}
