import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Aviao[] avioes = new Aviao[10];
        Navio[] navios = new Navio[10];

        // Criando os objetos com construtor vazio
        for (int i = 0; i < 10; i++) {
            avioes[i] = new Aviao();
            navios[i] = new Navio();
        }

        // Cadastro de aviões
        for (int i = 0; i < 10; i++) {
            System.out.println("\n=== Cadastro do Avião " + (i + 1) + " ===");
            avioes[i].entrada(sc);
            avioes[i].reajustarPreco(5); // reajuste de exemplo
        }

        // Cadastro de navios
        for (int i = 0; i < 10; i++) {
            System.out.println("\n=== Cadastro do Navio " + (i + 1) + " ===");
            navios[i].entrada(sc);
            System.out.println("Passageiros por Tripulante: " + navios[i].passageirosPorTripulantes());
        }

        // Exibir todos cadastrados
        System.out.println("\n=== Lista Final de Aviões ===");
        for (Aviao aviao : avioes) {
            aviao.imprimir();
            System.out.println("-------------------");
        }

        System.out.println("\n=== Lista Final de Navios ===");
        for (Navio navio : navios) {
            navio.imprimir();
            System.out.println("-------------------");
        }

        sc.close();
    }
}
