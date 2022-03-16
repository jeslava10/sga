package co.todosistemassti.sga.models.mappers;

import co.todosistemassti.sga.models.Employees;
import co.todosistemassti.sga.models.dtos.EmployeesDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeesMapper {

    EmployeesMapper INSTANCE = Mappers.getMapper( EmployeesMapper.class );

    EmployeesDto employeeToEmployeeDto(Employees employees);

    Employees employeeDtoToEmployee(EmployeesDto employeesDto);

}
