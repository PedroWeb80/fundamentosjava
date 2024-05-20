package exercicios.listas.exercicio1;

public class Program {
    public static void main(String[] args) {
        ListaTarefa tarefas = new ListaTarefa();
        var t1 = new Tarefa("Levar lixo");
        var t2 = new Tarefa("cavar poço");
        var t3 = new Tarefa("Limpar casa");

        tarefas.adicionarTarefa(t1);
        tarefas.adicionarTarefa(t2);
        tarefas.adicionarTarefa(t3);

        tarefas.removerTarefa("cavar poço");
        System.out.println("Total Tarefas: " + tarefas.totalTarefas());
        tarefas.descricoes();
    }
}
