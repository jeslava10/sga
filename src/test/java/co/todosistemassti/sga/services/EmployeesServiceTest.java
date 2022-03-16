package co.todosistemassti.sga.services;

import co.todosistemassti.sga.models.Employees;
import co.todosistemassti.sga.repositories.EmployeesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmployeesServiceTest {

    @Autowired
    EmployeesRepository repository;

    @Test
    void findAllEmployees() {
        List<Employees> employees = repository.findAll();
        assertThat(employees).isNotEmpty();
    }
}