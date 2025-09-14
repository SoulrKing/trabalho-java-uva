import java.util.InputMismatchException;
import java.util.Scanner;

public class MeioTransporte {
    protected int capacidadeTanque;
    protected int numeroPassageiros;
    protected double preco;

    // Construtor vazio
    public MeioTransporte() {
        this.capacidadeTanque = 0;
        this.numeroPassageiros = 0;
        this.preco = 0.0;
    }

    // Construtor com parâmetros
    public MeioTransporte(int capacidadeTanque, int numeroPassageiros, double preco) {
        this.capacidadeTanque = capacidadeTanque;
        this.numeroPassageiros = numeroPassageiros;
        this.preco = preco;
    }

    // Getters e Setters
    public int getCapacidadeTanque() { return capacidadeTanque; }
    public void setCapacidadeTanque(int capacidadeTanque) { this.capacidadeTanque = capacidadeTanque; }

    public int getNumeroPassageiros() { return numeroPassageiros; }
    public void setNumeroPassageiros(int numeroPassageiros) { this.numeroPassageiros = numeroPassageiros; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    // Métodos auxiliares de leitura
    protected int lerInt(Scanner sc, String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido! Digite um número inteiro.");
                sc.nextLine();
            }
        }
    }

    protected double lerDouble(Scanner sc, String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido! Digite um número real.");
                sc.nextLine();
            }
        }
    }

    protected String lerString(Scanner sc, String msg) {
        System.out.print(msg);
        sc.nextLine(); // limpar buffer
        return sc.nextLine();
    }

    // Métodos
    public void imprimir() {
        System.out.println("Capacidade do Tanque: " + capacidadeTanque);
        System.out.println("Número de Passageiros: " + numeroPassageiros);
        System.out.println("Preço: " + preco);
    }

    public void entrada(Scanner sc) {
        capacidadeTanque = lerInt(sc, "Capacidade do tanque: ");
        numeroPassageiros = lerInt(sc, "Número de passageiros: ");
        preco = lerDouble(sc, "Preço: ");
    }
}
