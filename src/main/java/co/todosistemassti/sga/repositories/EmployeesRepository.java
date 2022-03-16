package co.todosistemassti.sga.repositories;

import co.todosistemassti.sga.models.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees,Long> {

}
