package co.todosistemassti.sga.services;

import co.todosistemassti.sga.Utilities.DateUtilities;
import co.todosistemassti.sga.models.Activities;
import co.todosistemassti.sga.models.dtos.ActivitiesDto;
import co.todosistemassti.sga.models.dtos.EmployeesDto;
import co.todosistemassti.sga.models.mappers.ActivitiesMapper;
import co.todosistemassti.sga.models.mappers.EmployeesMapper;
import co.todosistemassti.sga.repositories.ActivitiesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivitiesService {

    private final ActivitiesRepository activitiesRepository;

    public List<ActivitiesDto> findAllActivities (){
        List<ActivitiesDto> activitiesDtoList = activitiesRepository.findAll().stream()
                .map(ActivitiesMapper.INSTANCE::activityToActivityDto)
                .collect(Collectors.toList());

        for (ActivitiesDto activitiesDto:activitiesDtoList) {
            activitiesDto.setLateDay(DateUtilities.calculateDaysLate(activitiesDto.getExecutionDate()
                    ,activitiesDto.getExecutionHour()));
        }

        return activitiesDtoList;

    }

    public ActivitiesDto saveActivities (ActivitiesDto ActivitiesDto){
        if(ActivitiesDto != null){
            ActivitiesDto activitiesDto =   ActivitiesMapper.INSTANCE
                    .activityToActivityDto(
                            activitiesRepository.save(
                                    ActivitiesMapper.INSTANCE.activityDtoToActivity(ActivitiesDto)));

            activitiesDto.setLateDay(DateUtilities.calculateDaysLate(activitiesDto.getExecutionDate()
                    ,activitiesDto.getExecutionHour()));
            return activitiesDto;
        }
        return null;
    }

    public ActivitiesDto updateActivities (ActivitiesDto ActivitiesDto){
        if(ActivitiesDto != null){
            ActivitiesDto activitiesDto =  ActivitiesMapper.INSTANCE
                    .activityToActivityDto(
                            activitiesRepository.save(
                                    ActivitiesMapper.INSTANCE.activityDtoToActivity(ActivitiesDto)));

            activitiesDto.setLateDay(DateUtilities.calculateDaysLate(activitiesDto.getExecutionDate()
                    ,activitiesDto.getExecutionHour()));
            return activitiesDto;
        }
        return null;
    }

    public Optional<Activities> findActivitiesById(Long id) {

        return activitiesRepository.findById(id);

    }

    public void deleteById(ActivitiesDto activitiesDto){
        activitiesRepository.delete(ActivitiesMapper.INSTANCE.activityDtoToActivity(activitiesDto));
    }

    public Optional<Activities> findActivitiesByEmployeesAndDescription(EmployeesDto employeesDto , String descripcion){

        return activitiesRepository
                .findActivitiesByEmployeeIdAndAndDescription(
                        EmployeesMapper.INSTANCE.employeeDtoToEmployee(employeesDto),descripcion);

    }


}
