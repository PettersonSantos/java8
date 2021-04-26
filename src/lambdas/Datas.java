package lambdas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Datas {
    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now();

        LocalDate proximaOlimpiadas = LocalDate.of(2021, Month.JULY, 20);

        System.out.println(proximaOlimpiadas.getYear() - hoje.getYear());

        System.out.println(Period.between(hoje, proximaOlimpiadas));

        System.out.println(proximaOlimpiadas.plusYears(4));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(proximaOlimpiadas.format(formatter));

        DateTimeFormatter formatterHours = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.format(formatterHours));

    }
}
