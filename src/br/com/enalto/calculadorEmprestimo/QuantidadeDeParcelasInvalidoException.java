package br.com.enalto.calculadorEmprestimo;

public class QuantidadeDeParcelasInvalidoException extends RuntimeException {
    public QuantidadeDeParcelasInvalidoException(String message){
        super(message);
    }
}
