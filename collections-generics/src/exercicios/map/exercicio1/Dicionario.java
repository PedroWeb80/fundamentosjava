package exercicios.map.exercicio1;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    Map<String, String> palavras;

    public Dicionario() {
        palavras = new HashMap<String, String>();
    }

    public void adicionarPalavra(String palavra, String definicao) {
        palavras.put(palavra.toUpperCase(), definicao);
    }

    public void removerPalavra(String palavra) {
        palavras.remove(palavra.toUpperCase());
    }
    public void exibirPalavras() {
        System.out.println(palavras.keySet());
    }

    public String pesquisarPalavra(String palavra) {
        return palavras.get(palavra.toUpperCase());
    }
    public static void main(String[] args) {
        Dicionario dic = new Dicionario();

        dic.adicionarPalavra("Rolha", "Objeto de pano");
        dic.adicionarPalavra("porca", "substantivo concreto, objeto");
        dic.adicionarPalavra("acabrunhar", "ato de pegar, se apoçar");

        dic.removerPalavra("rolha");
    System.out.println(dic.pesquisarPalavra("Porca"));
        dic.exibirPalavras();
    }
}
