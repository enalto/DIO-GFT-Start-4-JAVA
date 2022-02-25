package br.com.enalto.collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SimulaLancamentoDeDados {

    public static void main(String[] args) {

        Map<Integer, Integer> lancamentosDado = new HashMap<>();
        Random random = new Random();
        int min=1;
        int max=6;
        for (int i = 1; i <= 100; i++) {
            Integer numeroSorteado = random.nextInt((max - min) + 1) + min;
            System.out.println(i+"= "+numeroSorteado);
            lancamentosDado.put(i, numeroSorteado);
        }

    }
}
