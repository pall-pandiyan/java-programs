import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class timeDate {
    public static void main(String[] args) {
        LocalDate ld = LocalDate.now();
        LocalTime lt = LocalTime.now();
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("LocalDate: "+ld);
        System.out.println("LocalTime: "+lt);
        System.out.println("LocalDateTime: "+ldt);
        System.out.println("DateTimeFormatter: "+ldt.format(dtf));
    }
}

/*
the output will be..
LocalDate: 2022-03-28
LocalTime: 16:59:59.998819688
LocalDateTime: 2022-03-28T16:59:59.998875867
DateTimeFormatter: 28/03/2022 16:59
*/