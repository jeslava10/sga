package co.todosistemassti.sga.services;

import co.todosistemassti.sga.models.Employees;
import co.todosistemassti.sga.models.dtos.ActivitiesDto;
import co.todosistemassti.sga.models.dtos.EmployeesDto;
import co.todosistemassti.sga.models.mappers.EmployeesMapper;
import co.todosistemassti.sga.repositories.EmployeesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeesService {

    private final EmployeesRepository employeesRepository;

    public List<EmployeesDto> findAllEmployees (){
        return employeesRepository.findAll().stream().map(EmployeesMapper.INSTANCE::employeeToEmployeeDto).collect(Collectors.toList());
    }

    public EmployeesDto saveEmployees (EmployeesDto employeesDto){
        if(employeesDto != null){
            return EmployeesMapper.INSTANCE
                    .employeeToEmployeeDto(
                            employeesRepository.save(
                                    EmployeesMapper.INSTANCE.employeeDtoToEmployee(employeesDto)));
        }
        return null;
    }

    public EmployeesDto updateEmployees (EmployeesDto employeesDto){
        if(employeesDto != null){
            return EmployeesMapper.INSTANCE
                    .employeeToEmployeeDto(
                            employeesRepository.save(
                                    EmployeesMapper.INSTANCE.employeeDtoToEmployee(employeesDto)));
        }
        return null;
    }

    public Optional<Employees> findEmployeesById(Long id) {

        return employeesRepository.findById(id);

    }

    public void deleteById(EmployeesDto employeesDto){
        employeesRepository.delete(EmployeesMapper.INSTANCE.employeeDtoToEmployee(employeesDto));
    }

}
