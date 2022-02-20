package br.com.enalto.calculadorEmprestimo;

public class Main {
    public static void main(String[] args) {
        Emprestimo emprestimo = new Emprestimo(100000.0, 2.0, 12);
        System.out.println("Valor do financiamento= " + emprestimo.getValorDoFinanciamento());
        System.out.println("Taxa de juros= " + emprestimo.getTaxaDeJuros());
        System.out.println("Quantidade de parcelas= " + emprestimo.getQuantidadeDeParcelas());

        for (int i = 0; i < emprestimo.getQuantidadeDeParcelas(); i++) {
            double valorDaParcela = emprestimo.getValorDoFinanciamento()
                    / emprestimo.getQuantidadeDeParcelas();

            double valorJuroDaParcela = valorDaParcela *
                    Math.pow(1+(emprestimo.getTaxaDeJuros()/100),
                    emprestimo.getQuantidadeDeParcelas() - i);

            double valorParcelaMaisJuros = valorDaParcela + valorJuroDaParcela;
            System.out.printf("Parcela %d valor r$ %.2f\n", i+1, valorParcelaMaisJuros);
        }
    }
}
