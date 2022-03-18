package co.todosistemassti.sga.models.mappers;

import co.todosistemassti.sga.models.Activities;
import co.todosistemassti.sga.models.dtos.ActivitiesDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ActivitiesMapper {

    ActivitiesMapper INSTANCE = Mappers.getMapper( ActivitiesMapper.class );

    ActivitiesDto activityToActivityDto(Activities activities);

    Activities activityDtoToActivity(ActivitiesDto activitiesDto);

}
