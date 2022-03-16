package co.todosistemassti.sga.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ActivitiesDto implements Serializable {
    private final Long id;
    private final String description;
    private final Long employeeId;
    private final Long executionDate;
    private final String status;

    private final Integer lateDay;

}
