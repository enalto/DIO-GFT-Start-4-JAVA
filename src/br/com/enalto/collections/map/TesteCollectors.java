package br.com.enalto.collections.map;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class TesteCollectors {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "bb", "ccc", "dd");

        Map<String, Integer> result = list.stream()
                .collect(toMap(Function.identity(), String::length));

        System.out.println(result);
    }
}
