package com.go2climb.app.agency.api;

import com.go2climb.app.agency.domain.model.entity.Agency;
import com.go2climb.app.agency.domain.service.AgencyService;
import com.go2climb.app.agency.mapping.AgencyMapper;
import com.go2climb.app.agency.resource.AgencyResource;
import com.go2climb.app.agency.resource.CreateAgencyResource;
import com.go2climb.app.agency.resource.UpdateAgencyResource;
import com.go2climb.app.tourist.domain.model.entity.Tourist;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/agencies")
@AllArgsConstructor
@Tag(name = "Agencies", description = "It is the controller of the Agencies table")
public class AgencyController {
    private final AgencyService agencyService;
    private final AgencyMapper mapper;

    @Operation(summary = "Post Agency")
    @PostMapping
    public AgencyResource save(@RequestBody CreateAgencyResource resource) {
        resource.setPassword(new BCryptPasswordEncoder().encode(resource.getPassword()));
        return mapper.toResource( agencyService.save( mapper.toModel(resource) ) );
    }

    @Operation(summary = "Get all Agencies")
    @GetMapping
    public List<Agency> getAll() {
        return agencyService.getAll();
    }

    @Operation(summary = "Get by Id -  Agencies, return only one element")
    @GetMapping("{id}")
    public Agency getById(@PathVariable Integer id) {
        return agencyService.getById(id).get();
    }

    @Operation(summary = "Get by email -  Agencies, return only one element")
    @GetMapping("email/{email}")
    public Agency getByEmail(@PathVariable String email) {
        return agencyService.getByEmail(email).get();
    }

    @Operation(summary = "Put by Id -  Agencies, it is necessary to send the Body object")
    @PutMapping("{id}")
    public ResponseEntity<AgencyResource> update(@PathVariable Integer id, @RequestBody UpdateAgencyResource resource) {
        if(id.equals(resource.getId())) {
            AgencyResource agencyResource = mapper.toResource(agencyService.update(mapper.toModel(resource)));
            return new ResponseEntity<>(agencyResource, HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "Delete by Id")
    @DeleteMapping("{id}")
    public ResponseEntity<AgencyResource> delete(@PathVariable Integer id) {
        if (agencyService.deleteById(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
