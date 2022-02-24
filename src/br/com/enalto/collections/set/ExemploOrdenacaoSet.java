package br.com.enalto.collections.set;


import java.util.*;

public class ExemploOrdenacaoSet {
    public static void main(String[] args) {
        System.out.println("\tOrdem aleatória");
        Set<Serie> series = new HashSet<>() {{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that 70'", "comedia", 25));
        }};

        // exibir as informações
        System.out.println("lista com HashSet");

        for (Serie serie : series) {
            System.out.printf("%s - %s - %d\n", serie.getNome(), serie.getGenero(), serie.getTempoEpisodio());
        }

        // exibir as informações na ordem que foram inseridas
        // neste caso deve-se utilizar linkedhashset
        Set<Serie> series1 = new LinkedHashSet<>() {{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that 70'", "comedia", 25));

        }};
        System.out.println("\nlista com linkedHashSet");
        for (Serie serie : series1) {
            System.out.printf("%s - %s - %d\n", serie.getNome(), serie.getGenero(), serie.getTempoEpisodio());
        }

        // listar os elementos na ordem natural
        // implementação da interface Comparable, ordenação pelo tempo do episodio
        Set<Serie> series2 = new TreeSet<>() {{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that 70'", "comedia", 25));
        }};

        System.out.println();
        System.out.println(series2);

        // listar os elementos ordenando por Nome/Genero/TempoEpisodio
        System.out.println("\nlista com TreeSet ordenando por Nome/Genero/TempoEpisodio");

        Set<Serie> series3 = new TreeSet<>(new Comparator<Serie>() {
            @Override
            public int compare(Serie s1, Serie s2) {
                int nome = s1.getNome().compareToIgnoreCase(s2.getNome());
                if (nome != 0) return nome;

                int genero = s1.getGenero().compareToIgnoreCase(s2.getGenero());
                if(genero!=0) return genero;

                return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
            }
        }) {{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that 70'", "comedia", 25));

        }};
        System.out.println(series3);

    }
}

class Serie implements Comparable<Serie> {
    private String nome;
    private String genero;
    private int tempoEpisodio;

    public Serie(String nome, String genero, int tempoEpisodio) {
        this.nome = nome;
        this.genero = genero;
        this.tempoEpisodio = tempoEpisodio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getTempoEpisodio() {
        return tempoEpisodio;
    }

    public void setTempoEpisodio(int tempoEpisodio) {
        this.tempoEpisodio = tempoEpisodio;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", tempoEpisodio=" + tempoEpisodio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return tempoEpisodio == serie.tempoEpisodio && nome.equals(serie.nome) && genero.equals(serie.genero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempoEpisodio);
    }

    @Override
    public int compareTo(Serie o) {
        int tempoEpisodio = Integer.compare(this.getTempoEpisodio(), o.getTempoEpisodio());
        if (tempoEpisodio != 0) {
            return tempoEpisodio;
        }

        return this.getGenero().compareTo(o.getGenero());
    }
}
