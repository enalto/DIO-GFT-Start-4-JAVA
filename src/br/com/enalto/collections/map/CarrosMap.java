package br.com.enalto.collections.map;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class CarrosMap {
    public static void main(String[] args) {

        System.out.println("Dicionario com carros e respectivos consumos médios");
        Map<String, Double> carros = new HashMap<>() {{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
            put("corolla", 12d);
            put("up", 22.0);
        }};

        System.out.println(carros);

        // substituir o consumo do gol por 15.2
        System.out.println("Alterado o consumo do gol para 15.2");
        carros.put("gol", 15.2);
        System.out.println(carros);

        // conferir se o modelo tucson está no dicionario
        System.out.println("Tucson está no MAP?");

        System.out.println(carros.get("tucson"));
        System.out.println(carros.containsKey("tucson"));

        // exibir o consumo do uno
        double consumoUno = carros.get("uno");
        System.out.println(consumoUno);

        // exibir o terceiro modelo adicionado

        // exibir todos os modelos
        carros.keySet().stream().forEach(System.out::println);

        Set<String> modelos = carros.keySet();
        System.out.println(modelos);


        // exibir os consumos
        carros.values().stream().forEach(System.out::println);

        Collection<Double> values = carros.values();
        System.out.println(values);

        // exibir o modelo mais economico
        System.out.println("Modelo mais economico");
        Double max = Collections.max(carros.values());

        Set<Map.Entry<String, Double>> entries = carros.entrySet();
        entries.stream().forEach(new Consumer<Map.Entry<String, Double>>() {
            @Override
            public void accept(Map.Entry<String, Double> stringDoubleEntry) {
                if (stringDoubleEntry.getValue() == max) {
                    System.out.println(stringDoubleEntry);
                }
            }
        });

        // exibir modelo menos economico
        System.out.println("Modelo menos economico");
        Double min = Collections.min(carros.values());

        Set<Map.Entry<String, Double>> entrySet = carros.entrySet();

        entrySet.stream().forEach(new Consumer<Map.Entry<String, Double>>() {
            @Override
            public void accept(Map.Entry<String, Double> stringDoubleEntry) {
                if (stringDoubleEntry.getValue() == min) {
                    System.out.println(stringDoubleEntry);
                }
            }
        });


        // exibir a soma dos consumos

        System.out.println("Soma dos consumos");

        double somaDosConsumos = carros.values()
                .stream()
                .reduce(0d, (subtotal, element) -> (subtotal + element))
                .doubleValue();

        System.out.println(somaDosConsumos);

        // outra forma
        System.out.println("Soma dos consumos");

        Double somaReduce = carros.entrySet()
                .stream()
                .reduce(0d, (consumoParcial, carro) -> consumoParcial + carro.getValue(), Double::sum);

        System.out.println(somaReduce);


        // exibir a media dos valores

        System.out.println("Average");
        OptionalDouble average = carros.values().stream().mapToDouble(d -> d).average();
        System.out.println(average.orElse(0d));

        // Remover os modelos com consumo igual 15.6
        System.out.println("Removendo os carros com consumo igual 15.6");
        carros.entrySet().removeIf(new Predicate<Map.Entry<String, Double>>() {
            @Override
            public boolean test(Map.Entry<String, Double> stringDoubleEntry) {
                if (stringDoubleEntry.getValue() == 15.6) {
                    return true;
                }
                return false;
            }
        });

        System.out.println(carros);

        // exibir os carros na ordem em que foram inseridos
        // utilizar linkedHasMap

        System.out.println("listando os carros na ordem em que foram inseridos");
        Map<String, Double> linkedHashMapCarros = new LinkedHashMap<>() {{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
            put("corolla", 12d);
            put("up", 22.0);
        }};

        System.out.println(linkedHashMapCarros);


        // listar os carros na ordem de modelo
        System.out.println("listando os carros na ordem de modelo");
        Map<String, Double> treeMapCarros = new TreeMap<>() {{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
            put("corolla", 12d);
            put("up", 22.0);
        }};

        System.out.println(treeMapCarros);

    }
}
