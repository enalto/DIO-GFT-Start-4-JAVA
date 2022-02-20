package br.com.enalto.calculadorEmprestimo;

import java.util.Scanner;

public class CalcularEmprestimo {

    private static double valorDoFinanciamento;
    private static double taxaDeJuros;
    private static double quantidadeDeParcelas;

    public static void main(String[]args){
        leiaParametros();
    }

    private static void leiaParametros(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Valor do financiamento ");
        valorDoFinanciamento=scanner.nextDouble();
        System.out.println("Taxa de juros");
    }
}
