package br.com.enalto.calculadorEmprestimo;

public class ValorDoFinanciamentoInvalidoException extends RuntimeException {
    public ValorDoFinanciamentoInvalidoException(String message){
        super(message);
    }
}
