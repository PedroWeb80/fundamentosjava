package exercicios.listas.exercicio2;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<Item> items;

    public Carrinho() {
        this.items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        this.items.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome) {
        List<Item> ItemRemover = new ArrayList<>();
        ItemRemover = items.stream()
                .filter(i -> i.getNome().equalsIgnoreCase(nome))
                .toList();
        items.removeAll(ItemRemover);
    }

    public double calcularValorTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getPreço() * item.getQuantidade();
        }

        return total;
    }

    public void exibirItems() {
        System.out.println("---------------------------------------------------");
        System.out.printf("%-15s", "|Descrição|");
        System.out.printf("%20s","|Quantidade|");
        System.out.printf("%15s","|Preço|");

        items.forEach(item -> {
            System.out.println("");
            System.out.printf("%-.,15s %15d %17.2f", item.getNome(), item.getQuantidade(), item.getPreço());
        });
        System.out.println("");
    }

    public static void main(String[] args) {
        Carrinho car = new Carrinho();
        
        car.adicionarItem("boneco", 25.0, 20);
        car.adicionarItem("Chapelão", 15.0, 10);
        car.adicionarItem("Malha de fibra", 5.0, 100);
        
        car.exibirItems();
        System.out.println("");
        System.out.println("Total: " + car.calcularValorTotal());


        car.removerItem("boneco");

        car.exibirItems();

        System.out.println("");
        System.out.println("Total: " + car.calcularValorTotal());
    }

}
