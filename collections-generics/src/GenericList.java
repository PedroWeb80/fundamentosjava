import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Pedro Daniel
 * @version 1.0
 */
public class GenericList {

    public static void main(String[] args) {
        List<String> names = new ArrayList<String>();
        names.add("Moises");
        names.add("Karina");
        names.add("Melissa");

        var nameResult = names.stream()
                .filter(name -> name.toLowerCase().equals("karina"))
                .collect(Collectors.toList());
        
        System.out.println(nameResult);
    }

}