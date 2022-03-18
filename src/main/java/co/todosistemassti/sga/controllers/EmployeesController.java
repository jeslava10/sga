package co.todosistemassti.sga.controllers;

import co.todosistemassti.sga.models.Employees;
import co.todosistemassti.sga.models.dtos.EmployeesDto;
import co.todosistemassti.sga.models.mappers.EmployeesMapper;
import co.todosistemassti.sga.services.EmployeesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
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
    ResponseEntity<List<EmployeesDto>> findAllEmployees (){

        List<EmployeesDto> employeesDtoList = employeesService.findAllEmployees();
        if (employeesDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employeesDtoList, HttpStatus.OK);
    }

    @PostMapping("/save")
    ResponseEntity<EmployeesDto> saveEmployees (@Valid  @RequestBody EmployeesDto employeesDto){

        try {
            return new ResponseEntity<>(employeesService.saveEmployees(employeesDto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/update")
    ResponseEntity<EmployeesDto> updateEmployees (@Valid @RequestBody EmployeesDto employeesDto){
        try {
            return new ResponseEntity<>(employeesService.updateEmployees(employeesDto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<EmployeesDto> getEmployeesById(@PathVariable("id") Long id) {
        Optional<Employees> employeesDtoOptional = employeesService.findEmployeesById(id);

        if (employeesDtoOptional.isPresent()) {
            return new ResponseEntity<>(EmployeesMapper.INSTANCE.employeeToEmployeeDto(employeesDtoOptional.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/delete")
    public  ResponseEntity<String> getEmployeesDelete(@RequestBody EmployeesDto employeesDto) {
        try {
            employeesService.deleteById(employeesDto);
            return new ResponseEntity<>("Eliminado", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
