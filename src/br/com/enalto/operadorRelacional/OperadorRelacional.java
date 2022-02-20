package br.com.enalto.operadorRelacional;

public class OperadorRelacional {

    public static void main(String[] args) {
        String nome1 = "abc";
        String nome2 = "abc";

        String nome3 = new String("abc");

        System.out.println(nome1.equals(nome2));
        System.out.println(nome1 == nome2);
        System.out.println(nome1.equals("abc"));

        System.out.println(nome2==nome3);
        System.out.println(nome2.equals(nome3));

    }
}
