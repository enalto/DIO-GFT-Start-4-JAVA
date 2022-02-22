package br.com.enalto.estruturaRepeticao;

import java.util.Scanner;

public class Percentual {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double A = scan.nextDouble();
        double B = scan.nextDouble();

        double C = ((B/A)-1)*100;

        System.out.printf("%.2f%%\n", C);
    }
}
