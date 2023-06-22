package com.go2climb.app.agencyreviews.api;


import com.go2climb.app.agencyreviews.domain.model.entity.AgencyReview;
import com.go2climb.app.agencyreviews.domain.service.AgencyReviewService;
import com.go2climb.app.agencyreviews.mapping.AgencyReviewMapper;
import com.go2climb.app.agencyreviews.resource.AgencyReviewResource;
import com.go2climb.app.agencyreviews.resource.CreateAgencyReviewResource;
import com.go2climb.app.agencyreviews.resource.UpdateAgencyReviewResource;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.List;

@RestController
@RequestMapping("api/agency_review")
@AllArgsConstructor
public class AgencyReviewController {
    private final AgencyReviewService agencyReviewService;
    private final AgencyReviewMapper mapper;

    @PostMapping
    public AgencyReviewResource save(@RequestBody CreateAgencyReviewResource rresource) {
        return mapper.toResource( agencyReviewService.save(mapper.toModel(rresource)));
    }

    @GetMapping
    public List<AgencyReview> fetchAll() {
        return agencyReviewService.fetchAll();
    }

    @GetMapping("{id}")
    public AgencyReview fetchId(@PathVariable Integer id){
        //return this.mapper.toResource(agencyReviewService.fecthById(id).get());
        return  agencyReviewService.fecthById(id).get();
    }

    @PutMapping("{id}")
    public ResponseEntity<AgencyReviewResource> update(
            @PathVariable Integer id,
            @RequestBody UpdateAgencyReviewResource resource
    ){
        if (id.equals(resource.getId())){
            AgencyReviewResource studentResource = mapper.toResource(
                    agencyReviewService.update(mapper.toModel(resource)));
            return new ResponseEntity<>(studentResource, HttpStatus.OK);
            //return ResponseEntity.ok(studentResource);
            //return mapper.toResource(agencyReviewService.update(mapper.toModel(resource)));
        }
        else{
            return  ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        System.out.println("este es el id: " + id);
        if (agencyReviewService.deleteById(id)){
            //return ResponseEntity.ok().build();
            return new ResponseEntity<>(HttpStatus.OK);//USA ESTO
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("security/{id}")
    public List<AgencyReview> filterSecurity(@PathVariable Integer id){
        //return agencyReviewService.fetchById(id).get();
        return agencyReviewService.fetchAllSecurityScore(id);
    }
}
