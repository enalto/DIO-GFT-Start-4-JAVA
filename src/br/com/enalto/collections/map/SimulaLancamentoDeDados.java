package br.com.enalto.collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SimulaLancamentoDeDados {

    public static void main(String[] args) {

        Map<Integer, Integer> lancamentosDado = new HashMap<>();
        Random random = new Random();
        int min = 1;
        int max = 6;
        for (int i = 1; i <= 100; i++) {
            Integer numeroSorteado = random.nextInt((max - min) + 1) + min;
            System.out.println(i + "= " + numeroSorteado);
            lancamentosDado.put(i, numeroSorteado);
        }

        int um, dois, tres, quatro, cinco, seis, numeroSorteado;
        um = dois = tres = quatro = cinco = seis = numeroSorteado = 0;

        for (Map.Entry<Integer, Integer> entry : lancamentosDado.entrySet()) {
            numeroSorteado = entry.getValue();
            switch (numeroSorteado) {
                case 1:
                    um++;
                    break;
                case 2:
                    dois++;
                    break;
                case 3:
                    tres++;
                    break;
                case 4:
                    quatro++;
                    break;
                case 5:
                    cinco++;
                    break;
                case 6:
                    seis++;
                    break;
            }
        }

        System.out.println("\nQuantidade de vezes que o numero foi sorteado");
        System.out.println("Número um= "+um);
        System.out.println("Número dois= "+dois);
        System.out.println("Número tres= "+tres);
        System.out.println("Número quatro= "+quatro);
        System.out.println("Número um= "+cinco);
        System.out.println("Número um= "+seis);

        System.out.println("\nTotal= "+(um+dois+tres+quatro+cinco+seis));
    }
}
