package co.todosistemassti.sga.models;

import lombok.*;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "activities")
public class Activities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "execution_date")
    private Long executionDate;

    @Column(name = "status")
    private String status;


}
