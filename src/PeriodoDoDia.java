import java.time.LocalTime;
import java.time.Period;

public class PeriodoDoDia {

    public static void main(String[] args){
        init();
    }

    private static void init(){
        LocalTime horaAtual=LocalTime.now();
        if(horaAtual.isBefore(LocalTime.of(12,00))){
            System.out.println("Bom dia, hora atual= "+LocalTime.now());
        }else if(horaAtual.isAfter(LocalTime.of(18,00))){
            System.out.println("Boa noite, hora atual= "+LocalTime.now());
        }else{
            System.out.println("Boa tarde, hora atual= "+LocalTime.now());
        }
    }

}

