public class Moto extends Veiculo implements Promocao{
    private String tipoFreio;

    public Moto(String placa, String marca, String modelo, int ano, double preco, String tipoFreio) {
        super(placa, marca, modelo, ano, preco);
        this.tipoFreio = tipoFreio;
    }

    public String getTipoFreio() {
        return tipoFreio;
    }

    public void setTipoFreio(String tipoFreio) {
        this.tipoFreio = tipoFreio;
    }

    @Override
    public String exibirDetalhes() {
        return String.format("|| MOTO | Placa: %s | Marca: %s | Modelo: %s | Ano: %d | Preço: R$ %.2f | Tipo de freio: %s ||",
                getPlaca(), getMarca(), getModelo(), getAno(), getPreco(), getTipoFreio());
    }

    @Override
    public double aplicarDesconto(double valor, double desconto) {
        double descontoAplicado = desconto;

        if (descontoAplicado > descontoMaxMoto * 100) {
            return -1; //valor especial para indicar que excedeu o desconto
        }

        double valorDesconto = (valor * descontoAplicado) / 100.0;
        return valor - valorDesconto;
    }

}
