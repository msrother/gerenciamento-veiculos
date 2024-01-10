import java.util.*;

public class Revenda {
    private List<Veiculo> veiculos;
    private Map<String, Veiculo> veiculosRemovidos = new HashMap<>();

    public Revenda() {
        this.veiculos = new ArrayList<>();
    }
    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public void removerVeiculo(String placa) {
        Iterator<Veiculo> iterator = veiculos.iterator();
        while (iterator.hasNext()) {
            Veiculo veiculo = iterator.next();
            if (veiculo.getPlaca().equals(placa)) {
                iterator.remove();
                veiculosRemovidos.put(placa, veiculo);
                System.out.println("Veículo com placa " + placa + " removido com sucesso.");
                return;
            }
        }
        System.out.println("\n Veículo não encontrado com a placa especificada.");
    }

    public void exibirTodosDetalhesVeiculosRemovidos() {
        if (veiculosRemovidos.isEmpty()) {
            System.out.println("\n Nenhum veículo foi removido até o momento.");
            return;
        } else {
            for (Map.Entry<String, Veiculo> entry : veiculosRemovidos.entrySet()) {
                String placa = entry.getKey();
                Veiculo veiculo = entry.getValue();
               // System.out.println("Placa: " + placa);
                System.out.println(veiculo.exibirDetalhes());
                System.out.println("----------------------------------------");
            }
        }
    }

    public void listarVeiculos() {
        if (veiculos.isEmpty()) {
            System.out.println("\n A revenda não possuí veículos cadastrados!");
        } else {
            for (Veiculo veiculo : veiculos) {
                System.out.println(veiculo.exibirDetalhes());
            }
        }

    }

    public void adicionarDesconto(String placa, double desconto) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                if (veiculo instanceof Promocao) {
                    Promocao veiculoComDesconto = (Promocao) veiculo;
                    double precoOriginal = veiculo.getPreco();
                    double precoComDesconto = veiculoComDesconto.aplicarDesconto(precoOriginal, desconto);

                    if (precoComDesconto == -1) {
                        System.out.println("\n Desconto de " + desconto + "% excede o limite máximo permitido. O desconto não foi aplicado ao veículo com placa " + placa);
                        return;
                    }

                    veiculo.setPreco(precoComDesconto);
                    System.out.println("Desconto de " + desconto + "% aplicado com sucesso ao veículo com placa " + placa);
                    return;

                } else {
                    System.out.println("O veículo com placa " + placa + " não suporta desconto.");
                    return;
                }
            }
        }
        System.out.println("\n==> Veículo não encontrado com a placa especificada.");
    }
}
