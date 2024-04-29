import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in)){
            
            System.out.println("Digite o primeiro valor ");
            int primeiro = sc.nextInt();

            System.out.println("Digite o segundo valor");
            int segundo = sc.nextInt();
            
            contar(primeiro,segundo);
            
        } catch (ParametrosInvalidosException e) {
            System.err.print("Error " + e.getMessage());
        }
        
    }

    static void contar(int valor1, int valor2) throws ParametrosInvalidosException{
        if(valor1 > valor2)
            throw new ParametrosInvalidosException();
         
            int resultado = valor2 - valor1;

        for(int i=0; i < resultado; i++) {
            System.out.println("Imprimindo o Número " + (i + 1));
         }
    }
}
