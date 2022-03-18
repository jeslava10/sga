package co.todosistemassti.sga.models.dtos;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class ActivitiesDto implements Serializable {

    private final Long id;
    private final String description;
    private final EmployeesDto employeeId;
    private final LocalDate executionDate;
    private final Long executionHour;
    private final Integer statusActivity;

    private  Long lateDay;

}
