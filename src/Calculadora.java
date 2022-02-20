import java.util.Scanner;

public class Calculadora {

    private static double numero1;
    private static double numero2;
    private static String operador;

    public static void main(String[] args) {
        leiaNumerosEOperador();

        if (!validarNumerosEOperadores()) {
            throw new IllegalArgumentException();
        }

        System.out.println(calcula());
    }

    private static void leiaNumerosEOperador() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o primeiro número: ");
        numero1 = scanner.nextDouble();

        System.out.println("Operação ");
        operador = scanner.next();

        System.out.println("Digite o segundo número: ");
        numero2 = scanner.nextDouble();

    }

    private static boolean validarNumerosEOperadores() {
        if (numero2 == 0 & operador.equals("/")) {
            throw new IllegalArgumentException();
        } else if (!operadorIsValid()) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    private static boolean operadorIsValid() {
        switch (operador) {
            case "+":
                return true;
            case "-":
                return true;
            case "*":
                return true;
            case "/":
                return true;
            case "^":
                return true;
            default:
                return false;
        }
    }

    private static double calcula() {
        switch (operador) {
            case "+":
                return numero1 + numero2;
            case "-":
                return numero1 - numero2;
            case "*":
                return numero1 * numero2;
            case "/":
                return numero1 / numero2;
            case "^":
                return Math.pow(numero1, numero2);
            default:
                return 0.0;
        }

    }
}
