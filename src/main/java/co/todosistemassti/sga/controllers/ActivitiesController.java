package co.todosistemassti.sga.controllers;

import co.todosistemassti.sga.models.Activities;
import co.todosistemassti.sga.models.dtos.ActivitiesDto;
import co.todosistemassti.sga.models.mappers.ActivitiesMapper;
import co.todosistemassti.sga.services.ActivitiesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping("/activities")
@Tag(name = "Activities", description = "The Activities API")
public class ActivitiesController {

   private final ActivitiesService activitiesService;

    @Operation(summary = "Find activities All", description = "All activities")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = ActivitiesDto.class)))),
            @ApiResponse(responseCode = "404", description = "activities not found") })
    @GetMapping("/all")
    ResponseEntity<List<ActivitiesDto>> findAllActivities (){

        List<ActivitiesDto> activitiesDtoList = activitiesService.findAllActivities();
        if (activitiesDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(activitiesDtoList, HttpStatus.OK);
    }

    @PostMapping("/save")
    ResponseEntity<ActivitiesDto> saveActivities ( @RequestBody ActivitiesDto activitiesDto){

        try {
            return new ResponseEntity<>(activitiesService.saveActivities(activitiesDto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/update")
    ResponseEntity<ActivitiesDto> updateActivities (  @RequestBody ActivitiesDto activitiesDto){
        try {
            return new ResponseEntity<>(activitiesService.updateActivities(activitiesDto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ActivitiesDto> getActivitiesById(@PathVariable("id") Long id) {
        Optional<Activities> activitiesDtoOptional = activitiesService.findActivitiesById(id);

        if (activitiesDtoOptional.isPresent()) {
            return new ResponseEntity<>(ActivitiesMapper.INSTANCE.activityToActivityDto(activitiesDtoOptional.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/delete")
    public  ResponseEntity<String> getActivitiesDelete(@RequestBody ActivitiesDto activitiesDto) {
        try {
            activitiesService.deleteById(activitiesDto);
            return new ResponseEntity<>("Eliminado", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/find/name")
    public ResponseEntity<Boolean> getActivitiesByEmployeesAndDescription(@RequestBody ActivitiesDto request) {
        Optional<Activities> activitiesDtoOptional = activitiesService.findActivitiesByEmployeesAndDescription(request.getEmployeeId(),request.getDescription());

        if (activitiesDtoOptional.isPresent()) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false,HttpStatus.OK);
        }
    }



}
