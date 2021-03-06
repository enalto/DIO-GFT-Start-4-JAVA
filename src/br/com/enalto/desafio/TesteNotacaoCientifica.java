package br.com.enalto.desafio;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class TesteNotacaoCientifica {

    public static void main(String[] args) {

        //Scanner leitor = new Scanner(System.in);

        //Double d = leitor.nextDouble();

        //NotacaoCientifica notacaoCientifica = new NotacaoCientifica(d.toString().toCharArray());

        //System.out.println(notacaoCientifica.getNotacaoCientifica());

        String s = "-0.000027";
        String s2 = "3.141592";
        String s3 = "602214085774.747474747474";
        String s4 = "-10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
        String s5 = "602214085774747474747474";
        String s6 = "0.99";


        NotacaoCientifica nc = new NotacaoCientifica(s.toCharArray());
        NotacaoCientifica nc2 = new NotacaoCientifica(s2.toCharArray());
        NotacaoCientifica nc3 = new NotacaoCientifica(s3.toCharArray());
        NotacaoCientifica nc4 = new NotacaoCientifica(s4.toCharArray());
        NotacaoCientifica nc5 = new NotacaoCientifica(s5.toCharArray());
        NotacaoCientifica nc6 = new NotacaoCientifica(s6.toCharArray());

        System.out.println(nc.getNotacaoCientifica());
        System.out.println(nc2.getNotacaoCientifica());
        System.out.println(nc3.getNotacaoCientifica());
        System.out.println(nc4.getNotacaoCientifica());
        System.out.println(nc5.getNotacaoCientifica());
        System.out.println(nc6.getNotacaoCientifica());
    }
}

class NotacaoCientifica {

    private char[] sequencia;
    private boolean isNegativo;
    private char[] digitos;
    private int indexOfDecimal;
    private String result;

    NotacaoCientifica(char[] sequencia) {
        this.sequencia = sequencia;
    }

    public String getNotacaoCientifica() {
        this.setDigitos(sequencia);
        this.removeDecimal();
        this.getMantissa();

        return result;
    }

    private void setDigitos(char[] sequencia) {
        if (sequencia[0] == '-') {
            isNegativo = true;
            digitos = Arrays.copyOfRange(sequencia, 1, sequencia.length);
        } else {
            digitos = sequencia;
        }
        setIndexOfDecimal();
    }

    private void removeDecimal() {
        String s = new String(digitos);
        String s2 = s.replace(".", "");
        digitos = s2.toCharArray();
    }

    private boolean isExpoentNegativo() {
        if (indexOfDecimal > 0) {
            if (getIndexFirstNumber() + 1 > getIndexOfDecimal()) {
                return true;
            }
        }
        return false;
    }

    private int getIndexFirstNumber() {
        for (int i = 0; i < digitos.length; i++) {
            if (digitos[i] != '0' && digitos[i] != '.') return i;
        }
        return 0;
    }

    private int getIndexOfDecimal() {
        return indexOfDecimal;
    }

    private void setIndexOfDecimal() {
        indexOfDecimal = new String(digitos).indexOf(".");
    }

    private void getMantissa() {
        int startNumero = getIndexFirstNumber();
        StringBuilder mantissa = new StringBuilder();

        for (int i = startNumero; i < digitos.length; i++) {
            mantissa.append(digitos[i]);
        }

        mantissa.insert(1, '.');
        String sf = String.format("%.4f", Double.valueOf(mantissa.toString()));

        String sinal = isNegativo ? "-" : "+";
        result = sinal + arredondar(mantissa.toString()) + getExpoente();
    }

    private String arredondar(String s) {
        DecimalFormat decimalFormat = new DecimalFormat("0.0000");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        String result = decimalFormat.format(Double.valueOf(s)).replace(",", ".");
        return result;
    }

    private String getExpoente() {
        if (digitos[0] != '0' && indexOfDecimal == 1) {
            return "E+00";
        }
        int expoente = 0;
        if (indexOfDecimal > 0) {

            if (getIndexFirstNumber() < indexOfDecimal) {
                expoente = indexOfDecimal - getIndexFirstNumber() - 1;
            } else {
                expoente = getIndexFirstNumber() - indexOfDecimal + 1;
            }
        } else {
            expoente = digitos.length - getIndexFirstNumber() - 1;
        }

        String sinalExpoente = isExpoentNegativo() ? "E-" : "E+";

        String sf = String.format("%02d", expoente);
        return sinalExpoente + sf;
    }
}


