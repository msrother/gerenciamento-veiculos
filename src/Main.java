public class Main {
    public static void main(String[] args) {

        // Instanciando alguns carros e motos
        Carro carro1 = new Carro("ABC1234", "Ford", "Focus", 2017, 35000.0, 4);
        Moto moto1 = new Moto("XYZ5678", "Honda", "CBR", 2021, 30000.0, "Disco");
        Carro carro2 = new Carro("DEF5678", "Chevrolet", "Onix", 2023, 60000.0, 4);
        Moto moto2 = new Moto("ETZ5612", "Yamaha", "R1", 2019, 57000,"ABS");

        // Criando uma instância de Revenda
        Revenda revenda = new Revenda();

        revenda.adicionarVeiculo(carro1);
        revenda.adicionarVeiculo(moto1);
        revenda.adicionarVeiculo(carro2);
        revenda.adicionarVeiculo(moto2);


        System.out.println("### Lista de Veículos antes do Desconto ###");
        revenda.listarVeiculos();

        // Aplicando desconto em carros (máximo de 10%)
        revenda.adicionarDesconto("ABC1234", 8);

        // Aplicando desconto em motos (máximo de 5%)
        revenda.adicionarDesconto("XYZ5678", 3);

        System.out.println("\n### Lista de Veículos após o Desconto ###");
        revenda.listarVeiculos();


        System.out.println("\n### Veículos removidos ####");
        revenda.removerVeiculo("DEF5678");
        revenda.removerVeiculo("ABC1234");
        revenda.removerVeiculo("XYZ5678");
        revenda.removerVeiculo("TTB3423"); //teste com placa não cadastrada

        revenda.exibirTodosDetalhesVeiculosRemovidos();




    }

}