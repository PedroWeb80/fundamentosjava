package exercicios.listas.exercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Pedro Daniel
 * @since 06/05/2024
 */
public class ListaTarefa {
    List<Tarefa> tarefas;

    public ListaTarefa() {
        this.tarefas = new ArrayList<Tarefa>();
    }

    /***
     * 
     * @param tarefa
     * @throws IllegalArgumentException
     */
    public void adicionarTarefa(Tarefa tarefa) throws IllegalArgumentException {
        if (tarefa.getDescricao().isEmpty()) {
            throw new IllegalArgumentException("Verifique se o argumento");
        }

        tarefas.add(tarefa);
    }

    /***
     * 
     * @param tarefa
     */
    public void removerTarefa(String descricao) {
        List<Tarefa> tarefasRemover = new ArrayList<>();
        tarefasRemover = tarefas.stream()
                .filter(t -> t.getDescricao()
                        .equalsIgnoreCase(descricao))
                .collect(Collectors.toList());
        tarefas.removeAll(tarefasRemover);

    }

    /***
     * 
     * @return
     */
    public int totalTarefas() {
        return tarefas.size();
    }

    public void descricoes() {
        tarefas.forEach(t -> {
            System.out.println(t.getDescricao());
        });
    }
}
