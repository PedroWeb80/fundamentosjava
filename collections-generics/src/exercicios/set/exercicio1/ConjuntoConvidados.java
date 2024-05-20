package exercicios.set.exercicio1;

import java.util.HashSet;
import java.util.Set;


public class ConjuntoConvidados {
    Set<Convidado> convidados;

    public ConjuntoConvidados() {
        this.convidados = new HashSet<>();
    }

    public void adicionarConvidado(String nome, int codigoConvite) {
        convidados.add(new Convidado(nome, codigoConvite));
    }

    public void removerConvidadoPorCodigoConvite(int codigo) {
        Convidado convidadoRemover = new Convidado();
        if(!convidados.isEmpty()) {
            for (Convidado convidado : convidados) {
                if(convidado.getCodigoConvite() == codigo) {
                    convidadoRemover = convidado;
                    break;
                }
            }

            convidados.remove(convidadoRemover);
        }
    }
    public int contarConvidados() {
        return convidados.size();
    }
    public void exibirConvidados() {
        convidados.forEach(c -> System.out.println(c.getNome()));
    }

    public static void main(String[] args) {
        ConjuntoConvidados convidados = new ConjuntoConvidados();
        convidados.adicionarConvidado("Joao", 1);
        convidados.adicionarConvidado("Pedro", 2);
        convidados.adicionarConvidado("Elias", 5);

        convidados.exibirConvidados();

        convidados.removerConvidadoPorCodigoConvite(2);
        System.out.println();
        convidados.exibirConvidados();
        
        System.out.println("Total convidados");
        System.out.println(convidados.contarConvidados());
    }
    
}
