package br.com.enalto.exception;

public class TrataException {
    public static void main(String[] args) {

        int[] numerador = {4, 5, 8, 10};
        int[] denominador = {2, 4, 0, 2, 8};

        for(int i=0; i<denominador.length; i++){
            try{
                double resultado = (double)numerador[i]/denominador[i];
                System.out.println(resultado);
            }catch(ArithmeticException e){
                System.out.println("Impossível dividir por zero.");
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Sequencia de dados inválida.");
            }
        }

    }
}
