package br.com.enalto.collections.list;

import java.util.*;

public class OrdenacaoList {
    public static void main(String[] args) {

        Gato john = new Gato("John", 12, Cor.PRETO);
        Gato simba = new Gato("Simba", 6, Cor.TIGRADO);
        Gato john2 = new Gato("John", 18, Cor.AMARELO);

        List<Gato> gatoList = new ArrayList<>(Arrays.asList(john, simba, john2));

        //listar os elementos pela ordem de inserção
        System.out.println("Lista na ordem de inserção");
        System.out.println(gatoList.toString());


        // listar os elementos por ordem aleatoria
        System.out.println("Lista na ordem aleatoria");
        Collections.shuffle(gatoList);
        System.out.println(gatoList.toString());

        //listar os elementos pela ordem natural
        //implementação da interface Comparable, metodo compareTo
        System.out.println("Lista na ordem natural");
        Collections.sort(gatoList);
        System.out.println(gatoList.toString());

        // listar os elementos por ordem de idade
        System.out.println("Lista na ordem idade");
        Collections.sort(gatoList, new Comparator<Gato>() {
            @Override
            public int compare(Gato o1, Gato o2) {
                return Integer.compare(o1.getIdade(), o2.getIdade());
            }
        });
        System.out.println(gatoList.toString());

        // implementação com stream
        gatoList.stream().sorted(new Comparator<Gato>() {
            @Override
            public int compare(Gato o1, Gato o2) {
                return Integer.compare(o1.getIdade(), o2.getIdade());
            }
        }).forEach(gato -> System.out.println(gato));


        // listar os elementos por ordem de cor
        System.out.println("Lista na ordem cor");

        Collections.sort(gatoList, new Comparator<Gato>() {
            @Override
            public int compare(Gato o1, Gato o2) {
                return o1.getCor().getName().compareToIgnoreCase(o2.getCor().getName());
            }
        });
        System.out.println(gatoList.toString());

        // implementação por stream
        System.out.println("\nLista na ordem cor, implementação por stream");

        gatoList.stream()
                .sorted(new Comparator<Gato>() {
                    @Override
                    public int compare(Gato o1, Gato o2) {
                        return o1.getCor().name().compareToIgnoreCase(o2.getCor().name());
                    }
                }).forEach(gato -> {
                    System.out.println(gato);
                });

        // ordenação por Nome+Cor+Idade
        System.out.println("\nLista na ordem Nome+Cor+Idade");
        gatoList.sort(new Comparator<Gato>() {
            @Override
            public int compare(Gato o1, Gato o2) {
                int nome = o1.getNome().compareToIgnoreCase(o2.getNome());
                if (nome != 0) return nome;

                int cor = o1.getCor().getName().compareToIgnoreCase(o2.getCor().getName());
                if (cor != 0) return cor;

                return Integer.compare(o1.getIdade(), o2.getIdade());
            }
        });
        System.out.println(gatoList);
        System.out.println("\nLista na ordem Nome+Cor+Idade, implementação por stream");


    }

}

class Gato implements Comparable<Gato> {
    private String nome;
    private int idade;
    private Cor cor;

    Gato(String nome, int idade, Cor cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public Cor getCor() {
        return cor;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public String toString() {
        return "Gato{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor=" + cor +
                '}';
    }

    @Override
    public int compareTo(Gato gato) {
        return this.getNome().compareToIgnoreCase(gato.getNome());
    }
}

enum Cor {

    PRETO("Preto"),
    TIGRADO("Tigrado"),
    AMARELO("Amarelo");

    private String name;

    Cor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}