import java.util.Scanner;

public class Aviao extends MeioTransporte {
    private String prefixo;
    private String dataRevisao;

    // Construtor vazio
    public Aviao() {
        super();
        this.prefixo = "";
        this.dataRevisao = "";
    }

    // Construtor com parâmetros
    public Aviao(String prefixo, String dataRevisao, int capacidadeTanque, int numeroPassageiros, double preco) {
        super(capacidadeTanque, numeroPassageiros, preco);
        this.prefixo = prefixo;
        this.dataRevisao = dataRevisao;
    }

    // Getters e Setters
    public String getPrefixo() { return prefixo; }
    public void setPrefixo(String prefixo) { this.prefixo = prefixo; }

    public String getDataRevisao() { return dataRevisao; }
    public void setDataRevisao(String dataRevisao) { this.dataRevisao = dataRevisao; }

    // Métodos
    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Prefixo: " + prefixo);
        System.out.println("Data Revisão: " + dataRevisao);
    }

    @Override
    public void entrada(Scanner sc) {
        boolean confirmado = false;
        // Entrada inicial
        super.entrada(sc);
        sc.nextLine(); // limpar buffer
        System.out.print("Prefixo: ");
        prefixo = sc.nextLine();
        System.out.print("Data de Revisão: ");
        dataRevisao = sc.nextLine();

        while (!confirmado) {
            System.out.println("\n=== Dados digitados do Avião ===");
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
                System.out.println("4 - Prefixo");
                System.out.println("5 - Data de Revisão");
                int opc = lerInt(sc, "Opção: ");
                sc.nextLine(); // limpar buffer

                switch (opc) {
                    case 0:
                        super.entrada(sc);
                        sc.nextLine();
                        System.out.print("Prefixo: ");
                        prefixo = sc.nextLine();
                        System.out.print("Data de Revisão: ");
                        dataRevisao = sc.nextLine();
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
                        System.out.print("Prefixo: ");
                        prefixo = sc.nextLine();
                        break;
                    case 5:
                        System.out.print("Data de Revisão: ");
                        dataRevisao = sc.nextLine();
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            }
        }
    }

    public void reajustarPreco(double percentual) {
        preco += preco * (percentual / 100);
    }
}
