import java.util.Scanner;

public class Navio extends MeioTransporte {
    private String nome;
    private int numeroTripulantes;
    private String dataLancamento;

    // Construtores
    public Navio() {
        super();
        this.nome = "";
        this.numeroTripulantes = 0;
        this.dataLancamento = "";
    }

    public Navio(String nome) {
        this();
        this.nome = nome;
    }

    public Navio(String nome, int numeroTripulantes) {
        this();
        this.nome = nome;
        this.numeroTripulantes = numeroTripulantes;
    }

    public Navio(String nome, int numeroTripulantes, String dataLancamento) {
        this();
        this.nome = nome;
        this.numeroTripulantes = numeroTripulantes;
        this.dataLancamento = dataLancamento;
    }

    public Navio(String nome, int capacidadeTanque, int numeroPassageiros, int numeroTripulantes, double preco, String dataLancamento) {
        super(capacidadeTanque, numeroPassageiros, preco);
        this.nome = nome;
        this.numeroTripulantes = numeroTripulantes;
        this.dataLancamento = dataLancamento;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getNumeroTripulantes() { return numeroTripulantes; }
    public void setNumeroTripulantes(int numeroTripulantes) { this.numeroTripulantes = numeroTripulantes; }

    public String getDataLancamento() { return dataLancamento; }
    public void setDataLancamento(String dataLancamento) { this.dataLancamento = dataLancamento; }

    // Métodos
    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Nome: " + nome);
        System.out.println("Número de Tripulantes: " + numeroTripulantes);
        System.out.println("Data de Lançamento: " + dataLancamento);
    }

    @Override
    public void entrada(Scanner sc) {
        boolean confirmado = false;
        // Entrada inicial
        super.entrada(sc);
        sc.nextLine();
        System.out.print("Nome: ");
        nome = sc.nextLine();
        numeroTripulantes = lerInt(sc, "Número de Tripulantes: ");
        sc.nextLine();
        System.out.print("Data de Lançamento: ");
        dataLancamento = sc.nextLine();

        while (!confirmado) {
            System.out.println("\n=== Dados digitados do Navio ===");
            imprimir();
            System.out.print("Os dados estão corretos? (S/N): ");
            String resp = sc.nextLine().trim().toUpperCase();

            if (resp.equals("S")) {
                confirmado = true;
            } else {
                System.out.println("\nEscolha o campo para alterar (ou 0 para redigitar tudo):");
                System.out.println("1 - Capacidade do tanque");
                System.out.println("2 - Número de passageiros");
                System.out.println("3 - Preço");
                System.out.println("4 - Nome");
                System.out.println("5 - Número de Tripulantes");
                System.out.println("6 - Data de Lançamento");
                int opc = lerInt(sc, "Opção: ");
                sc.nextLine();

                switch (opc) {
                    case 0:
                        super.entrada(sc);
                        sc.nextLine();
                        System.out.print("Nome: ");
                        nome = sc.nextLine();
                        numeroTripulantes = lerInt(sc, "Número de Tripulantes: ");
                        sc.nextLine();
                        System.out.print("Data de Lançamento: ");
                        dataLancamento = sc.nextLine();
                        break;
                    case 1:
                        capacidadeTanque = lerInt(sc, "Capacidade do tanque: ");
                        break;
                    case 2:
                        numeroPassageiros = lerInt(sc, "Número de passageiros: ");
                        break;
                    case 3:
                        preco = lerDouble(sc, "Preço: ");
                        break;
                    case 4:
                        System.out.print("Nome: ");
                        nome = sc.nextLine();
                        break;
                    case 5:
                        numeroTripulantes = lerInt(sc, "Número de Tripulantes: ");
                        break;
                    case 6:
                        System.out.print("Data de Lançamento: ");
                        dataLancamento = sc.nextLine();
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            }
        }
    }

    public double passageirosPorTripulantes() {
        if (numeroTripulantes == 0) return 0;
        return (double) numeroPassageiros / numeroTripulantes;
    }
}
