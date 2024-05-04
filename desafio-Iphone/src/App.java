import edu.pedro.models.IPhone;

public class App {
    public static void main(String[] args) throws Exception {
        IPhone IPhone11 = new IPhone();

        IPhone11.atender();
        IPhone11.ligar();
        IPhone11.iniciarCorreioVoz();

        IPhone11.exibirPagina();
        IPhone11.adicionarNovaAba();
        IPhone11.atualizarPagina();

        IPhone11.tocar();
        IPhone11.pausar();
        IPhone11.selecionarMusica();
    }
}
