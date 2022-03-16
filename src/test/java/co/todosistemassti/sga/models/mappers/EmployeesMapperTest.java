package co.todosistemassti.sga.models.mappers;

import co.todosistemassti.sga.models.Employees;
import co.todosistemassti.sga.models.dtos.EmployeesDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EmployeesMapperTest {

    @Test
    void employeeToEmployeeDto() {

        //given
        Employees employees = new Employees(1L,"Jeison","mayunga","jeison@gmail.com");

        //when
        EmployeesDto employeesDto = EmployeesMapper.INSTANCE.employeeToEmployeeDto( employees );

        //then
        assertThat( employeesDto ).isNotNull();
        assertThat( employeesDto.getEmail() ).isEqualTo( employees.getEmail() );

    }
}