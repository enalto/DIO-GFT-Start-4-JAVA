package br.com.enalto.quadrilatero;

public class Quadrilatero {
    private static double ladoA;
    private static double ladoB;
    private static double ladoC;
    private static double ladoD;


    public static double calculaArea(double lado) {
        return lado*lado;
    }

    public static double calculaArea(double ladoA, double ladoB) {
        return ladoA * ladoB;
    }

    public static double calculaArea(double baseMaior, double baseMenor, double altura) {
        return ((baseMaior + baseMenor) / 2) * altura;
    }

}
