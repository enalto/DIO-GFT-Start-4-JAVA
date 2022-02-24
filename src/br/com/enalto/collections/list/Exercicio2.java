package br.com.enalto.collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.function.Predicate;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Questionamento> questionamentos = new ArrayList<>(){{
           add(new Questionamento("Telefonou para a vítima?", "nao"));
           add(new Questionamento("Esteve no local do crime?", "nao"));
           add(new Questionamento("Mora perto da vítima?", "nao"));
           add(new Questionamento("Devia para a vítima?", "nao"));
           add(new Questionamento("Já trabalhou com a vítima?", "nao"));
        }};

        for(Questionamento questionamento: questionamentos){
            System.out.println(questionamento.getPergunta());
            questionamento.setResposta(scan.next());
        }

        int countRespostas = (int)questionamentos.stream().filter(new Predicate<Questionamento>() {
            @Override
            public boolean test(Questionamento questionamento) {
                if (questionamento.getResposta().equalsIgnoreCase("sim")) {
                    return true;
                }
                return false;
            }
        }).count();

        verificarInocenciaOuCulpabilidade(countRespostas);

    }

    private static void verificarInocenciaOuCulpabilidade(int countRespostas) {
        switch(countRespostas){
            case 2:
                System.out.println("Suspeita");
                break;
            case 3:
                case 4:
                System.out.println("Cumplice");
                break;
            case 5:
                System.out.println("Assino");
                break;
            default:
                System.out.println("Inocente");
        }
    }
}

class Questionamento{
    private String pergunta;
    private String resposta;

    public Questionamento(String pergunta, String resposta) {
        this.pergunta = pergunta;
        this.resposta = resposta;
    }

    public String getPergunta() {
        return pergunta;
    }

    public String getResposta(){
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
}
