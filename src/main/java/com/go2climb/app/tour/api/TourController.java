package com.go2climb.app.tour.api;

import com.go2climb.app.tour.domain.model.entity.Tour;
import com.go2climb.app.tour.domain.service.TourService;
import com.go2climb.app.tour.mapping.TourMapper;
import com.go2climb.app.tour.resource.TourResource;
import com.go2climb.app.tour.resource.CreateTourResource;
import com.go2climb.app.tour.resource.UpdateTourResource;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tours")
@AllArgsConstructor
public class TourController {
    private final TourService tourService;
    private final TourMapper mapper;

    @PostMapping
    public TourResource save(@RequestBody CreateTourResource resource) {
        return mapper.toResource( tourService.save( mapper.toModel(resource) ) );
    }

    @GetMapping
    public List<Tour> getAll() {
        return tourService.getAll();
    }

    @GetMapping("{id}")
    public TourResource getById(@PathVariable Integer id) {
        return this.mapper.toResource(tourService.getById(id).get());
    }

    @PutMapping("{id}")
    public ResponseEntity<TourResource> update(@PathVariable Integer id, @RequestBody UpdateTourResource resource) {
        if(id.equals(resource.getId())) {
            TourResource tourResource = mapper.toResource(tourService.update(mapper.toModel(resource)));
            return new ResponseEntity<>(tourResource, HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<TourResource> delete(@PathVariable Integer id) {
        if (tourService.deleteById(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
