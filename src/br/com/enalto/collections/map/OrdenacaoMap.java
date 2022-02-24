package br.com.enalto.collections.map;

import java.util.*;

public class OrdenacaoMap {

    public static void main(String[] args) {

        Map<String, Livro> livroMap = new HashMap<>() {{
            put("Hawking, Stephen", new Livro("Uma breve historia do tempo", 256));
            put("Duhigg, Charles", new Livro("O poder do hábito", 408));
            put("Harai, Yuval Naah", new Livro("Lições para o século 21", 432));
        }};

        // exibir em ordem aleatório somente nome livro e autor

        System.out.println("Exibir autor e livro");
        livroMap.entrySet().stream().forEach(entry -> {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        });

        System.out.println("------------------------");
        System.out.println();

        // outra implementação
        System.out.println("outra implementação");
        for (Map.Entry<String, Livro> entry : livroMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().getNome());
        }

        // exibir pela ordem de inserção
        System.out.println("------------------------");
        System.out.println();
        System.out.println("Ordem de insercao");

        Map<String, Livro> linkedHashMapLivros = new LinkedHashMap<>() {{
            put("Hawking, Stephen", new Livro("Uma breve historia do tempo", 256));
            put("Duhigg, Charles", new Livro("O poder do hábito", 408));
            put("Harai, Yuval Naah", new Livro("Lições para o século 21", 432));
        }};

        System.out.println("Exibir autor e livro");
        linkedHashMapLivros.entrySet().stream().forEach(entry -> {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        });

        // outra implementação
        System.out.println("------------------------");
        System.out.println();

        System.out.println("outra implementação");
        for (Map.Entry<String, Livro> entry : linkedHashMapLivros.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().getNome());
        }

        System.out.println("------------------------");
        System.out.println();
        System.out.println("Por ordem de autor, Key");

        Map<String, Livro> treeMap = new TreeMap<>(linkedHashMapLivros);

        System.out.println(treeMap);


        System.out.println("------------------------");
        System.out.println();
        System.out.println("Por ordem de alfabetica dos autores");
        // tem que trabalhar com TreeSet
        Set<Map.Entry<String, Livro>> treeSet = new TreeSet<>(new Comparator<Map.Entry<String, Livro>>() {
            @Override
            public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
                return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
            }
        });

        treeSet.addAll(linkedHashMapLivros.entrySet());

        System.out.println(treeSet);


        System.out.println("------------------------");
        System.out.println();
        System.out.println("Por ordem de paginas");
        // tem que trabalhar com TreeSet
        Set<Map.Entry<String, Livro>> treeSet1 = new TreeSet<>(new Comparator<Map.Entry<String, Livro>>() {
            @Override
            public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
                return Integer.compare(l1.getValue().getPaginas(), l2.getValue().getPaginas());
            }
        });

        treeSet1.addAll(linkedHashMapLivros.entrySet());

        System.out.println(treeSet1);

    }
}

class Livro {
    private String nome;
    private Integer paginas;

    public Livro(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return nome.equals(livro.nome) && paginas.equals(livro.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", paginas=" + paginas +
                '}';
    }
}
