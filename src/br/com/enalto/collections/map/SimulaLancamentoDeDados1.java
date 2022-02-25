package br.com.enalto.collections.map;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class SimulaLancamentoDeDados1 {

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

        Map<Integer, List<Integer>> quantidadeDeSorteiosPorFace = lancamentosDado.values()
                .stream()
                .collect(groupingBy(Integer::intValue));

        Map<Integer, Long> quantidadeDeSorteiosPorFace1 = lancamentosDado.values()
                .stream()
                .collect(groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(quantidadeDeSorteiosPorFace);

        System.out.println(quantidadeDeSorteiosPorFace1);
    }

}
