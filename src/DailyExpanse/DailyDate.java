package DailyExpanse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class DailyDate {
    static public String currentDate() {
        DateTimeFormatter dtl = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate now = LocalDate.now();
        return dtl.format(now);
    }
    static public String currentMonth(){
        DateTimeFormatter dtl=DateTimeFormatter.ofPattern("MM-yyyy");
        LocalDate now=LocalDate.now();
        return dtl.format(now);
    }
}
