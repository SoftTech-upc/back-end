package com.go2climb.app.activity.mapping;

import com.go2climb.app.activity.domain.model.entity.Activity;
import com.go2climb.app.activity.resource.ActivityResource;
import com.go2climb.app.activity.resource.CreateActivityResource;
import com.go2climb.app.activity.resource.UpdateActivityResource;
import com.go2climb.app.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class ActivityMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public Activity toModel(CreateActivityResource resource) { return this.mapper.map(resource, Activity.class); }
    public Activity toModel(UpdateActivityResource resource) {
        return this.mapper.map(resource, Activity.class);
    }
    public ActivityResource toResource(Activity activity) {
        return this.mapper.map(activity, ActivityResource.class);
    }
}
