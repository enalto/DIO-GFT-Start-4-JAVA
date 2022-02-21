package br.com.enalto.estruturaRepeticao;

import java.util.Scanner;

public class NumerosPar {
    public static void main(String[] args) {
        int numero;
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o número: ");
        numero=scan.nextInt();

        for(int i=1; i<=numero; i++){
            if(i %2==0){
                System.out.println(i);
            }
        }
    }
}
