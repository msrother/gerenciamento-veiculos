public class Carro extends Veiculo implements Promocao {

    private int qtdPortas;

    public Carro(String placa, String marca, String modelo, int ano, double preco, int qtdPortas) {
        super(placa, marca, modelo, ano, preco);
       this.qtdPortas = qtdPortas;
    }

    public int getQtdPortas() {
        return qtdPortas;
    }

    public void setQtdPortas(int qtdPortas) {
        this.qtdPortas = qtdPortas;
    }

    @Override
    public String exibirDetalhes() {
        return String.format("|| CARRO | Placa: %s | Marca: %s | Modelo: %s | Ano: %d | Preço: R$ %.2f | Portas: %d ||",
        getPlaca(), getMarca(), getModelo(), getAno(), getPreco(), getQtdPortas());
    }

    @Override
    public double aplicarDesconto(double valor, double desconto) {
        double descontoAplicado = desconto;

        if (descontoAplicado > descontoMaxCarro * 100) {
            return -1; //valor especial para indicar que excedeu o desconto
        }

        double valorDesconto = (valor * descontoAplicado) / 100.0;
        return valor - valorDesconto;
    }

}
