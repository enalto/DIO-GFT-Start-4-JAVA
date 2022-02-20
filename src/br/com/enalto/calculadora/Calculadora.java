package br.com.enalto.calculadora;

public class Calculadora {

    private double numeroA;
    private double numeroB;

    public Calculadora(double numeroA, double numeroB) {
        this.numeroA = numeroA;
        this.numeroB = numeroB;
    }

    public double getNumeroA() {
        return numeroA;
    }

    public double getNumeroB(){
        return numeroB;
    }

    public double soma() {
        return numeroA + numeroB;
    }

    public double subatracao() {
        return numeroA - numeroB;
    }

    public Double divisao() {
        if (numeroB > 0) {
            return numeroA / numeroB;
        }
        return 0.0;
    }

    public Double multiplicacao() {
        return numeroA * numeroB;
    }

    public Double potencia() {
        return Math.pow(numeroA, numeroB);
    }

    public Double raizQuadrada() {
        return Math.sqrt(numeroA);
    }

}
