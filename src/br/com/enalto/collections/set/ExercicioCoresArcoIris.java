package br.com.enalto.collections.set;

import java.util.*;
import java.util.function.Predicate;

public class ExercicioCoresArcoIris {
    public static void main(String[] args) {

        Set<String> cores = new LinkedHashSet<>(){{
            add("vermelho");
            add("amarelo");
            add("laranja");
            add("anil");
            add("verde");
            add("azul");
            add("violeta");
        }};

        // exibir as cores, uma embaixo da outra
        cores.stream().forEach(cor->{
            System.out.println(cor);
        });

        // exibir a quantidade de cores
        System.out.println(cores.stream().count());

        int count=0;
        for (String cor: cores) {
            count++;
        }
        System.out.println(count);

        // exibir as cores em ordem alfabetica
        Set<String> cores1 = new TreeSet<>(){{
            add("vermelho");
            add("amarelo");
            add("laranja");
            add("anil");
            add("verde");
            add("azul");
            add("violeta");
        }};

        System.out.println(cores1);

        // exibir as cores na ordem inversa que foram informadas
        System.out.println("Cores invertidas");
        List<String> coresInvestidas = new ArrayList<>(cores1);
        Collections.reverse(coresInvestidas);

        System.out.println(coresInvestidas);

        // exibir as cores que começam com a letra v
        System.out.println("Somente cores que iniciam com v");
        cores1.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                if(s.startsWith("v")){
                    return true;
                }
                return false;
            }
        }).forEach(c->{
            System.out.println(c);
        });

        // remover todas as cores que começam com letra v
        System.out.println("Remover cores que iniciam com v");

        cores1.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                if (s.startsWith("v")) {
                    return true;
                }
                return false;
            }
        });

        System.out.println(cores1);

        cores1.clear();

        System.out.println("Conjunto vazio? "+cores1.isEmpty());
    }
}
