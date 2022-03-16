package co.todosistemassti.sga.repositories;

import co.todosistemassti.sga.models.Activities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivitiesRepository extends JpaRepository<Activities,Long> {

}
