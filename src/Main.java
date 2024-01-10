import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Revenda revenda = new Revenda();

        int opcao;
        do {
            System.out.println("\n### REVENDA DE VEÍCULOS ###");
            System.out.println("1. Adicionar Veículo");
            System.out.println("2. Remover Veículo");
            System.out.println("3. Listar Veículos");
            System.out.println("4. Aplicar Desconto");
            System.out.println("5. Listar Veículos Removidos");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        System.out.println("Informe o tipo de veículo (CARRO/MOTO):");
                        String tipoVeiculo = scanner.nextLine();

                        System.out.println("Informe a placa:");
                        String placa = scanner.nextLine().toUpperCase();

                        System.out.println("Informe a marca:");
                        String marca = scanner.nextLine();

                        System.out.println("Informe o modelo:");
                        String modelo = scanner.nextLine();

                        System.out.println("Informe o ano:");
                        int ano = Integer.parseInt(scanner.nextLine());

                        System.out.println("Informe o preço:");
                        double preco = Double.parseDouble(scanner.nextLine());

                        if ("Carro".equalsIgnoreCase(tipoVeiculo)) {
                            System.out.println("Informe o número de portas:");
                            int numeroPortas = Integer.parseInt(scanner.nextLine());

                            Carro novoCarro = new Carro(placa, marca, modelo, ano, preco, numeroPortas);
                            revenda.adicionarVeiculo(novoCarro);
                        } else if ("Moto".equalsIgnoreCase(tipoVeiculo)) {
                            System.out.println("Informe o tipo de freio:");
                            String tipoFreio = scanner.nextLine();

                            Moto novaMoto = new Moto(placa, marca, modelo, ano, preco, tipoFreio);
                            revenda.adicionarVeiculo(novaMoto);
                        } else {
                            System.out.println("\n Tipo de veículo não reconhecido. Tente novamente.");
                        }
                        break;
                    case 2:
                        System.out.print("Digite a placa do veículo que deseja remover: ");
                        String placaRemover = scanner.nextLine().toUpperCase();
                        revenda.removerVeiculo(placaRemover);
                        break;
                    case 3:
                        System.out.println("\n### Lista de Veículos ###");
                        revenda.listarVeiculos();
                        break;
                    case 4:
                        System.out.print("Digite a placa do veículo para aplicar desconto: ");
                        String placaDesconto = scanner.nextLine().toUpperCase();
                        System.out.print("Digite o percentual de desconto: ");
                        double percentual = Double.parseDouble(scanner.nextLine());
                        revenda.adicionarDesconto(placaDesconto, percentual);
                        break;
                    case 5:
                        System.out.println("\n### Lista de Veículos Removidos ###");
                        revenda.exibirTodosDetalhesVeiculosRemovidos();
                        break;
                    case 6:
                        System.out.println("\n Encerrando o programa...");
                        break;
                    default:
                        System.out.println("\n Opção inválida. Tente novamente.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("\n Erro: Por favor, insira apenas números válidos para a opção.");
                opcao = 0;

            }
        } while (opcao != 6);

        scanner.close();

    }

}