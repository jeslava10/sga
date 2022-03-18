package co.todosistemassti.sga.repositories;

import co.todosistemassti.sga.models.Activities;
import co.todosistemassti.sga.models.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActivitiesRepository extends JpaRepository<Activities,Long> {

     Optional<Activities> findActivitiesByEmployeeIdAndAndDescription(Employees employees , String description);

}
