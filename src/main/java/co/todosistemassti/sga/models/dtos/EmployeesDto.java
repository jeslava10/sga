package co.todosistemassti.sga.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class EmployeesDto implements Serializable {

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String email;
}
