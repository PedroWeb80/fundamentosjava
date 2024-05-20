// import java.util.Scanner;

// public class SimulacaoBancaria {

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         double saldo = 0;
//         // Loop infinito para manter o programa em execução até que o usuário decida
//         // sair
//         while (true) {

//             int opcao = scanner.nextInt();
//             System.out.println();
//             switch (opcao) {
//                 case 1:
//                     double deposito = scanner.nextDouble();

//                     if (verificaDeposito(deposito, saldo))
//                         saldo += deposito;
//                     else
//                         System.out.println("Valor do deposito deve ser maior que zero.");
//                     break;

//                 case 2:
//                     double saque = scanner.nextDouble();

//                     if (verificaSaldo(saque, saldo))
//                         saldo -= saque;
//                     else
//                         System.out.println("Valor do saque deve ser maior que zero e menor que valor do saldo.");
//                     break;

//                 case 3:
//                     System.out.println("Seu saldo atual é de  " + saldo);
//                     break;

//                 case 0:
//                     System.out.println("Sistema encerrado");
//                     System.exit(0);
//                 default:
//                     System.out.println("Opção inválida. Tente novamente.");
//             }

//         }
//     }

//     static boolean verificaDeposito(double deposito, double saldo) {
//         if (deposito <= 0)
//             return false;
//         return true;
//     }

//     static boolean verificaSaldo(double saque, double saldo) {
//         if (saque <= 0 || saque > saldo)
//             return false;
//         return true;
//     }

// }

// import java.util.Scanner;

// public class VerificadorNumeroConta {

//   public static void main(String[] args) {
//     Scanner scanner = new Scanner(System.in);

//     // TODO: Inicialize um bloco try-catch para capturar exceções:
//     try {
//       String numeroConta = scanner.nextLine();
//       verificarNumeroConta(numeroConta);
//     }

//     catch (IllegalArgumentException e) {
//       System.out.println("Numero de conta valido.");
//       System.out.println("Erro: " + e.getMessage());
//     }

//     finally {
//       scanner.close();
//     }
//   }

//   // Declaração do método verificarNumeroConta, que verifica se o número de conta
//   // tem exatamente 8 dígitos:
//   private static void verificarNumeroConta(String numeroConta) throws IllegalArgumentException {
//     if (numeroConta.length() < 8) {
//       throw new IllegalArgumentException("Digite exatamente 8 digitos.");
//     }

//   }
// }

// import java.util.Scanner;

// public class ControleSimplesDeSaques {

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in); 

//         double limiteDiario = scanner.nextDouble();

// // TODO: Crie um loop 'for' para iterar sobre os saques:

// // TODO: Solicite ao usuário o valor do saque:
           

// // TODO: Verifique se o valor do saque é zero, encerrando as transações:
// // Dica: Utilize um 'if/else' para verificar as condições do valorSaque e o limiteDiario;

           
// // TODO: Se o valor do saque não ultrapassar o limite diário, subtraia o valor do saque do limite diário:
            

// // TODO: Informe que o saque foi realizado e mostre o limite restante:
              
//             }
//         }

// // Fechamos o Scanner para evitar vazamento de recursos:
//         scanner.close(); 
//     }
// }