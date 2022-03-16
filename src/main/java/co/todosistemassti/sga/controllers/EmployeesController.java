package co.todosistemassti.sga.controllers;

import co.todosistemassti.sga.models.dtos.EmployeesDto;
import co.todosistemassti.sga.services.EmployeesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
@Tag(name = "Employees", description = "the Employees API")
public class EmployeesController {

   private final EmployeesService employeesService;

    @Operation(summary = "Find Employees All", description = "All Employees")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = EmployeesDto.class)))),
            @ApiResponse(responseCode = "404", description = "Employees not found") })
    @GetMapping("/all")
    List<EmployeesDto> findAllEmployees (){
        return employeesService.findAllEmployees();
    }

    RequestEntity<EmployeesDto> saveEmployess (@RequestBody EmployeesDto employeesDto){

        return  RequestEntity.
    }


}
