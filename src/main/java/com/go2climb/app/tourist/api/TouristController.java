package com.go2climb.app.tourist.api;

import com.go2climb.app.tourist.domain.model.entity.Tourist;
import com.go2climb.app.tourist.domain.service.TouristService;
import com.go2climb.app.tourist.mapping.TouristMapper;
import com.go2climb.app.tourist.resource.TouristResource;
import com.go2climb.app.tourist.resource.CreateTouristResource;
import com.go2climb.app.tourist.resource.UpdateTouristResource;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tourists")
@AllArgsConstructor
public class TouristController {
    private final TouristService touristService;
    private final TouristMapper mapper;

    @PostMapping
    public TouristResource save(@RequestBody CreateTouristResource resource) {
        resource.setPassword(new BCryptPasswordEncoder().encode(resource.getPassword()));
        return mapper.toResource( touristService.save( mapper.toModel(resource) ) );
    }

    @GetMapping
    public List<Tourist> getAll() {
        return touristService.getAll();
    }

    @GetMapping("{id}")
    public TouristResource getById(@PathVariable Integer id) {
        return this.mapper.toResource(touristService.getById(id).get());
    }

    @PutMapping("{id}")
    public ResponseEntity<TouristResource> update(@PathVariable Integer id, @RequestBody UpdateTouristResource resource) {
        if(id.equals(resource.getId())) {
            TouristResource touristResource = mapper.toResource(touristService.update(mapper.toModel(resource)));
            return new ResponseEntity<>(touristResource, HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<TouristResource> delete(@PathVariable Integer id) {
        if (touristService.deleteById(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
