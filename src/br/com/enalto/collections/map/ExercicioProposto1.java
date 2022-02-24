package br.com.enalto.collections.map;

import java.util.*;
import java.util.function.Predicate;

public class ExercicioProposto1 {
    public static void main(String[] args) {

        Map<String, Integer> populacao = new HashMap<>() {{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};

        // alterar a população do RN
        populacao.put("RN", 3534165);


        // inserir PB, caso não exista no MAPA
        if (!populacao.containsKey("PB")) populacao.put("PB", 4039277);
        System.out.println(populacao);

        // exibir a população de PE
        System.out.println("População de PE");
        System.out.println(populacao.get("PE"));

        // exibir todas as populações na ordem em que foram inseridas
        System.out.println("\t----------");
        System.out.println("População na ordem em que foram inseridas");
        Map<String, Integer> populacao1 = new LinkedHashMap<>() {{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534165);
            put("PB", 4039277);
        }};
        System.out.println(populacao1);

        // exibir os estados em ordem alfabetica
        System.out.println("\t----------");
        System.out.println("População na ordem alfabetica");
        Map<String, Integer> populacao2 = new TreeMap<>() {{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534165);
            put("PB", 4039277);
        }};

        System.out.println(populacao2);


        // exibir os estados com a menor população
        System.out.println("\t----------");
        System.out.println("Menor população");

        Optional<Map.Entry<String, Integer>> min = populacao2.entrySet().stream().min(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return Integer.compare(o1.getValue(), o2.getValue());
            }
        });

        System.out.println(min.get().getKey() + " - " + min.get().getValue());

        // exibir os estados com a maior população
        System.out.println("\t----------");
        System.out.println("Maior população");

        Optional<Map.Entry<String, Integer>> max = populacao2.entrySet().stream().max(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return Integer.compare(o1.getValue(), o2.getValue());
            }
        });

        System.out.println(max.get().getKey() + " - " + max.get().getValue());

        // exibir a soma da população destes estados
        System.out.println("\t----------");
        System.out.println("Soma da população com Stream reduce");

        Integer somaDaPopulacaoDosEstados = populacao2.values().stream().reduce(0, (parcial, element) -> (parcial + element));

        System.out.println(somaDaPopulacaoDosEstados);

        // exibir a media da população destes estados
        System.out.println("\t----------");
        System.out.println("Media da população");

        double media = (double)(somaDaPopulacaoDosEstados/populacao2.size());

        double asDouble = populacao2.values().stream().mapToDouble(i -> i).average().getAsDouble();
        System.out.println(asDouble);

        System.out.println(media);


        // exibir a media da população destes estados
        System.out.println("\t----------");
        System.out.println("Remover os estados com populacao menor que 4.000.000");

        populacao2.entrySet().removeIf(new Predicate<Map.Entry<String, Integer>>() {
            @Override
            public boolean test(Map.Entry<String, Integer> stringIntegerEntry) {
                if(stringIntegerEntry.getValue()<=4000000){
                    return true;
                }
                return false;
            }
        });

        System.out.println(populacao2);

        populacao2.clear();

        System.out.println("Dicionario vazio "+populacao2.isEmpty());
    }


}

enum UF implements Comparable<UF> {
    PE,
    AL,
    CE,
    RN,
    PB;
}
