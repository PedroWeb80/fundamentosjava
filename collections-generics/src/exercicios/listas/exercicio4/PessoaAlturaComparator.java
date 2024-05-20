package exercicios.listas.exercicio4;

import java.util.Comparator;


public class PessoaAlturaComparator implements Comparator<Pessoa>{

    @Override
    public int compare(Pessoa p1, Pessoa p2) {
        return Double.compare(p1.getAltura(), p2.getAltura());
    }

    
}