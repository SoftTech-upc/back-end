package com.go2climb.app.tourist.api;

import com.go2climb.app.tourist.domain.model.entity.Tourist;
import com.go2climb.app.tourist.domain.service.TouristService;
import com.go2climb.app.tourist.mapping.TouristMapper;
import com.go2climb.app.tourist.resource.TouristResource;
import com.go2climb.app.tourist.resource.CreateTouristResource;
import com.go2climb.app.tourist.resource.UpdateTouristResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Tourist", description = "It is the controller of the Tourist table")
public class TouristController {
    private final TouristService touristService;
    private final TouristMapper mapper;

    @Operation(summary = "Post Tourist")
    @PostMapping
    public TouristResource save(@RequestBody CreateTouristResource resource) {
        resource.setPassword(new BCryptPasswordEncoder().encode(resource.getPassword()));
        return mapper.toResource( touristService.save( mapper.toModel(resource) ) );
    }

    @Operation(summary = "Get all Tourist")
    @GetMapping
    public List<Tourist> getAll() {
        return touristService.getAll();
    }

    @Operation(summary = "Get by Id -  Tourist, return only one element")
    @GetMapping("{id}")
    public Tourist getById(@PathVariable Integer id) {
        return touristService.getById(id).get();
    }

    @Operation(summary = "Get by Email -  Tourist, return only one element")
    @GetMapping("email/{email}")
    public Tourist getByEmail(@PathVariable String email) {
        return touristService.getByEmail(email).get();
    }

    @Operation(summary = "Put by Id -  Tourist, it is necessary to send the Body object")
    @PutMapping("{id}")
    public ResponseEntity<TouristResource> update(@PathVariable Integer id, @RequestBody UpdateTouristResource resource) {
        if(id.equals(resource.getId())) {
            TouristResource touristResource = mapper.toResource(touristService.update(mapper.toModel(resource)));
            return new ResponseEntity<>(touristResource, HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "Delete by Id")
    @DeleteMapping("{id}")
    public ResponseEntity<TouristResource> delete(@PathVariable Integer id) {
        if (touristService.deleteById(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
