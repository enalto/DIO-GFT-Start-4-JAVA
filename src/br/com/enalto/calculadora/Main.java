package br.com.enalto.calculadora;

public class Main {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora(10, 5);

        System.out.printf("Divisão de %.2f por %.2f= %.2f\n", calc.getNumeroA(), calc.getNumeroB() , calc.divisao());

        System.out.printf("Subtração de %.2f por %.2f= %.2f\n", calc.getNumeroA(), calc.getNumeroB() , calc.subatracao());

        System.out.printf("Multiplicação de %.2f por %.2f= %.2f\n", calc.getNumeroA(), calc.getNumeroB() , calc.multiplicacao());

        System.out.printf("Soma de %.2f por %.2f= %.2f\n", calc.getNumeroA(), calc.getNumeroB() , calc.soma());
    }
}
