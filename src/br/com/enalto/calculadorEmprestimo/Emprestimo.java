package br.com.enalto.calculadorEmprestimo;

public class Emprestimo {

    private double valorDoFinanciamento;
    private double taxaDeJuros;
    private int quantidadeDeParcelas;

    public Emprestimo(double valorDoFinanciamento, double taxaDeJuros, int quantidadeDeParcelas) {
        if (!taxaDeJurosIsValida(taxaDeJuros)) {
            throw new TaxaDeJurosFinanciamentoInvalidaException("Taxa de juros inválida.");
        }else if(!valorDoFinanciamentoIsValido(valorDoFinanciamento)){
            throw new ValorDoFinanciamentoInvalidoException("Valor do financiamento incorreto.");
        }else if(!quantidadeDeParcelasIsValido(quantidadeDeParcelas)){
            throw new QuantidadeDeParcelasInvalidoException("Quantidade de parcelas incorreta.");
        }
        this.quantidadeDeParcelas = quantidadeDeParcelas;
        this.taxaDeJuros = taxaDeJuros;
        this.valorDoFinanciamento = valorDoFinanciamento;
    }

    public boolean taxaDeJurosIsValida(double taxaDeJuros) {
        if (taxaDeJuros <= 0 || taxaDeJuros > 100) {
            return false;
        }
        return true;
    }

    public boolean valorDoFinanciamentoIsValido(double valorDoFinanciamento){
        if(valorDoFinanciamento<=0){
            return false;
        }
        return true;
    }

    public boolean quantidadeDeParcelasIsValido(int quantidadeDeParcelas){
        if(quantidadeDeParcelas<=0)
            return false;
        return true;
    }

    public int getQuantidadeDeParcelas(){
        return quantidadeDeParcelas;
    }

    public double getValorDoFinanciamento(){
        return valorDoFinanciamento;
    }

    public double getTaxaDeJuros(){
        return taxaDeJuros;
    }

}