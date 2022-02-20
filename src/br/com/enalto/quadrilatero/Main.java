package br.com.enalto.quadrilatero;

public class Main {

    public static void main(String[]args){
        System.out.println("Quadrado com área= "+ Quadrilatero.calculaArea(2));
        System.out.println("Retangulo com área= "+ Quadrilatero.calculaArea(4, 2));
        System.out.println("Trapezio com área= "+ Quadrilatero.calculaArea(4, 2, 3));
    }
}
