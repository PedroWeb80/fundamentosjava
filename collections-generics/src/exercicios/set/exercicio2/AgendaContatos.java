package exercicios.set.exercicio2;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
    Set<Contato> contatosSet;

    public AgendaContatos() {
        contatosSet = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero) {
        contatosSet.add(new Contato(nome, numero));
    }

    public void exibirContatos() {
        contatosSet.forEach(c -> System.out.println(c.toString()));
    }
    
    public Set<Contato> pesquisarPorNome(String nome) {
        Set<Contato> contatosPorNome = new HashSet<>();
        if(!nome.isEmpty()) {
            contatosSet.forEach(c -> {
                if(c.getNome().startsWith(nome));
                    contatosPorNome.add(c);
            });
            return contatosPorNome;
        }
        return contatosPorNome;
    }

    public Contato atualizarNumero(String nome, int novoNumero) {
        Contato contatoAtualizado = null;
        if(!nome.isEmpty() && novoNumero > 0) {
            for(Contato c : contatosSet) {
                if(c.getNome().equalsIgnoreCase(nome)) {
                    c.setNumero(novoNumero);
                    contatoAtualizado = c;
                    break;
                }
            }
            return contatoAtualizado; 
        }
        return contatoAtualizado;
    }

    public static void main(String[] args) {
        AgendaContatos ag = new AgendaContatos();
        ag.adicionarContato("Pedro", 985598077);
        ag.adicionarContato("PedroDio", 985598077);
        ag.adicionarContato("Joao gil", 997598077);

        ag.exibirContatos();

        ag.atualizarNumero("Pedroio", 99999985);
        System.out.println();
        ag.exibirContatos();
    }
}
