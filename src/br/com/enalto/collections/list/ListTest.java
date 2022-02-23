package br.com.enalto.collections.list;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;


public class ListTest {

    public static void main(String[] args) {
        List<Double> listaNotas = new
                ArrayList<Double>(Arrays.asList(7d, 8.5, 9.3, 5.0, 7.0, 0.0, 3.6));

        // listaNotas.add(10d);

        System.out.println(listaNotas);
        listaNotas.remove(3.6d);

        System.out.println(listaNotas);

        // exibir a posiçõa da nota 5.0
        System.out.println("Posição da nota 5.0= " + listaNotas.indexOf(5.0d));

        // adicionar a nota 8.0 na posição 4
        listaNotas.add(4, 4.0);

        // substituir a nota 5.0 por 6.0
        int posicaoDaNota5 = listaNotas.indexOf(5d);
        listaNotas.set(posicaoDaNota5, 6d);
        System.out.println(listaNotas);

        // verificar se a nota 5.0 está na lista
        boolean estaNaLista = listaNotas.contains(5d);
        System.out.println("Elemento 5.0 está na lista?= " + estaNaLista);

        // exibir todas as notas na ordem que foram inseridas
        for (Double nota : listaNotas) {
            System.out.println(nota);
        }

        // exibir a terceira nota adicionada
        double terceiraNotaAdicionada = listaNotas.get(2);
        System.out.println("Terceira nota adicionada= " + terceiraNotaAdicionada);

        //exibir a menor nota
        // implementação com for
        double menor = 0d;
        for (double nota : listaNotas) {
            if (nota < menor) {
                menor = nota;
            }
        }
        System.out.println("Menor nota= " + menor);

        //implementação com stream
        double menorStream = listaNotas.stream()
                .mapToDouble(v -> v)
                .min().orElseThrow(NoSuchElementException::new);
        System.out.println("Menor nota= " + menorStream);

//        Comparator<Double> comparator = new Comparator<>() {
//            @Override
//            public int compare(Double o1, Double o2) {
//                return 0;
//            }
//        };

        Optional<Double> min = listaNotas.stream().min(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return o1.compareTo(o2);
            }
        });
        if (min.isPresent()) {
            System.out.println("Menor nota= " + min.get());
        }

        // exibir a maior nota
        // implementação com for
        double maior = 0d;
        for (double nota : listaNotas) {
            if (nota > maior) {
                maior = nota;
            }
        }
        System.out.println("Maior nota= " + maior);

        // implementação com stream
        double maiorStream = listaNotas.stream()
                .mapToDouble(v -> v).max()
                .orElseThrow(NoSuchElementException::new);

        System.out.println("Maior nota= " + maiorStream);

        Optional<Double> max = listaNotas.stream().max(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return o1.compareTo(o2);
            }
        });
        if (max.isPresent()) {
            System.out.println("Maior nota= " + max.get());
        }

        listaNotas
                .stream()
                .max((o1, o2) -> Double.compare(o1, o2))
                .ifPresent(maiorNota -> System.out.println("Nota máxima= " + maiorNota));


        // exibir a soma dos elementos
        Double soma = 0d;
        for (Double nota : listaNotas) {
            soma += nota;
        }
        System.out.println("Soma das notas= " + soma);

        // implementação com stream

        double somaStream = listaNotas.stream().mapToDouble(v -> v).sum();
        System.out.println("Soma das notas= " + somaStream);

        double somaReduce = listaNotas.stream().reduce(0d, (a, b) -> (a + b));
        System.out.println("Soma das notas= " + somaReduce);


        // exibir a médias das notas
        double media = soma / listaNotas.size();
        System.out.println("Media= " + media);

        // implementação com stream

        listaNotas
                .stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .ifPresent(av -> System.out.println("Média= " + av));

        // remover a nota 0

        listaNotas.remove(0d);

        // remover a nota na posicao 0

        listaNotas.remove(0);

        System.out.println(listaNotas);

        // remover as notas menores que 7
        listaNotas.removeIf(new Predicate<Double>() {
            @Override
            public boolean test(Double aDouble) {
                if (aDouble < 7) {
                    return true;
                }
                return false;
            }
        });
        System.out.println("removeif =" + listaNotas);

        // filtrar somente notas maiores que 7
        Stream<Double> doubleStreamMaioresQue7 = listaNotas.stream().filter(new Predicate<Double>() {
            @Override
            public boolean test(Double aDouble) {
                if (aDouble < 7) {
                    return false;
                }
                return true;
            }
        });

        doubleStreamMaioresQue7.forEach(nota -> {
            System.out.println(nota);
        });

        // limpar a lista

        listaNotas.clear();
        System.out.println("clear =" + listaNotas);


        // conferir se a lista está vazia
        System.out.println("lista vazia =" + listaNotas.isEmpty());


    }
}
