public interface Promocao {

    double aplicarDesconto(double valor, double desconto);
    static final double descontoMaxCarro = 0.1;
    static final double descontoMaxMoto = 0.05;

}
