package co.todosistemassti.sga.Utilities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateUtilities {

    public static Long calculateDaysLate(LocalDate executeDate , Long executeHour) {
        LocalDateTime nowDate = LocalDateTime.now();
        LocalDateTime lateDate = executeDate.atTime(executeHour.intValue(),0);
        Duration duration = Duration.between(lateDate ,nowDate);
        return duration.toDays();
    }


}
