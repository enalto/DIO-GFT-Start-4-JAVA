package br.com.enalto.collections.list;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.stream.Stream;

public class Exercicio1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<TemperaturaMedia> temperaturas = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            System.out.println("Informe a temperatura média do mês "+Mes.get(i));
            double temperaturaMediaDoMes = scan.nextDouble();
            temperaturas.add(new TemperaturaMedia(Mes.get(i), temperaturaMediaDoMes));
        }

        Stream<TemperaturaMedia> stream = temperaturas.stream();

        stream.forEach(t->{
            System.out.println(t);
        });

        OptionalDouble average = temperaturas
                .stream()
                .mapToDouble(value -> value.getTemperatura())
                .average();

        System.out.println("Média= "+average.getAsDouble());

    }
}

class TemperaturaMedia{
    private Mes mes;
    private double temperatura;

    public TemperaturaMedia(Mes mes, double temperatura) {
        this.mes = mes;
        this.temperatura = temperatura;
    }

    public String getMes() {
        return mes.name();
    }

    public double getTemperatura() {
        return temperatura;
    }

    @Override
    public String toString() {
        return "TemperaturaMedia{" +
                "mes=" + mes.name() +
                ", temperatura=" + temperatura +
                '}';
    }
}

enum Mes{
    JANEIRO(1),
    FEVEREIRO(2),
    MARCO(3),
    ABRIL(4),
    MAIO(5),
    JUNHO(6),
    JULHO(7),
    AGOSTO(8),
    SETEMBRO(9),
    OUTUBRO(10),
    NOVEMBRO(11),
    DEZEMBRO(12);

    private final int id;

    Mes(int id){
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public static Mes get(int mes){
        for(Mes m: Mes.values()){
            if(m.id==mes){
                return m;
            }
        }
        return null;
    }
}
