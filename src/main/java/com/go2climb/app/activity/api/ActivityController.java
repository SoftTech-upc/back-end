package com.go2climb.app.activity.api;

import com.go2climb.app.activity.domain.model.entity.Activity;
import com.go2climb.app.activity.domain.service.ActivityService;
import com.go2climb.app.activity.mapping.ActivityMapper;
import com.go2climb.app.activity.resource.ActivityResource;
import com.go2climb.app.activity.resource.CreateActivityResource;
import com.go2climb.app.activity.resource.UpdateActivityResource;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/activities")
@AllArgsConstructor
public class ActivityController {
    private final ActivityService activityService;
    private final ActivityMapper mapper;

    @PostMapping
    public ActivityResource save(@RequestBody CreateActivityResource resource) {
        return mapper.toResource( activityService.save( mapper.toModel(resource) ) );
    }

    @GetMapping
    public List<Activity> getAll() {
        return activityService.getAll();
    }

    @GetMapping("{id}")
    public ActivityResource getById(@PathVariable Integer id) {
        return this.mapper.toResource(activityService.getById(id).get());
    }

    @PutMapping("{id}")
    public ResponseEntity<ActivityResource> update(@PathVariable Integer id, @RequestBody UpdateActivityResource resource) {
        if(id.equals(resource.getId())) {
            ActivityResource activityResource = mapper.toResource(activityService.update(mapper.toModel(resource)));
            return new ResponseEntity<>(activityResource, HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ActivityResource> delete(@PathVariable Integer id) {
        if (activityService.deleteById(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
