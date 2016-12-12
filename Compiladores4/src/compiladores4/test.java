package compiladores4;

import java.util.Scanner;

public class test {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        AnalisadorLexico a = new AnalisadorLexico();
        int opcao = 0;
        do {
            System.out.println("Escolha uma opcao:");
            System.out.println("1 --- Adicionar token");
            System.out.println("2 --- Testar expressão");
            System.out.println("0 --- Sair");
            opcao = s.nextInt();
            switch (opcao) {
                case 1:
                    System.out.print("nome do token:");
                    String nome = s.next();
                    System.out.print("\n regex: ");
                    String regex = s.nextLine();
                    a.adicionarToken(nome, regex);
                    break;
                case 2:

                    System.out.print("Entrada: ");
                    String entrada = s.nextLine();
                    System.out.println("\n\n\n");
                    System.out.println("SAIDA:");
                    a.tokenizar(entrada);
                    System.out.println("\n\n\n");
                    
                    break;
            }
        } while (opcao != 0);

    }
}
