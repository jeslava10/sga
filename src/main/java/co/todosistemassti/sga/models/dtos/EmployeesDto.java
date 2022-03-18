package co.todosistemassti.sga.models.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class EmployeesDto implements Serializable {

    private final Long id;

    @NotBlank(message = "Los nombres son requeridos")
    @Schema(description = "Nombres", example = "Juan Jose")
    private final String firstName;

    @NotBlank(message = "Los Apellidos son requeridos")
    @Schema(description = "Apellidos", example = "Cano Perez")
    private final String lastName;

    @Email(message = "No tiene formato valido")
    @Schema(description = "Email", example = "Juan@gmail.com")
    private final String email;

}
