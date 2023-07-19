package com.go2climb.app.tour.api;

import com.go2climb.app.tour.domain.model.entity.Tour;
import com.go2climb.app.tour.domain.service.TourService;
import com.go2climb.app.tour.mapping.TourMapper;
import com.go2climb.app.tour.resource.TourResource;
import com.go2climb.app.tour.resource.CreateTourResource;
import com.go2climb.app.tour.resource.UpdateTourResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tours")
@AllArgsConstructor
@Tag(name = "Tour", description = "It is the controller of the Tour table")
public class TourController {
    private final TourService tourService;
    private final TourMapper mapper;

    @Operation(summary = "Post Tour")
    @PostMapping
    public TourResource save(@RequestBody CreateTourResource resource) {
        return mapper.toResource( tourService.save( mapper.toModel(resource) ) );
    }

    @Operation(summary = "Get all Tour")
    @GetMapping
    public List<Tour> getAll() {
        return tourService.getAll();
    }

    @Operation(summary = "return all Tours that are on sale")
    @GetMapping("offer")
    public List<Tour> getAllOffer() {
        return tourService.getAllOffer();
    }

    @Operation(summary = "returns a list of Tours ordered from the most recent date to the oldest")
    @GetMapping("date")
    public List<Tour> getAllDate() {
        return tourService.getOrderDateDesc();
    }

    @Operation(summary = "returns a list of Tours ordered by the Score criteria (this is an average)")
    @GetMapping("score")
    public List<Tour> getOrderScoreDesc() {
        return tourService.getOrderScoreDesc();
    }

    @GetMapping("{id}")
    public Tour getById(@PathVariable Integer id) {
        return tourService.getById(id).get();
    }

    @Operation(summary = "Get by Id -  Tour, return only one element")
    @PutMapping("{id}")
    public ResponseEntity<TourResource> update(@PathVariable Integer id, @RequestBody UpdateTourResource resource) {
        if(id.equals(resource.getId())) {
            TourResource tourResource = mapper.toResource(tourService.update(mapper.toModel(resource)));
            return new ResponseEntity<>(tourResource, HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "Delete by Id")
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (tourService.deleteById(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
