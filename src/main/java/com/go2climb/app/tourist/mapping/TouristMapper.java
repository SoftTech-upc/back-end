package com.go2climb.app.tourist.mapping;

import com.go2climb.app.shared.mapping.EnhancedModelMapper;
import com.go2climb.app.tourist.domain.model.entity.Tourist;
import com.go2climb.app.tourist.resource.CreateTouristResource;
import com.go2climb.app.tourist.resource.TouristResource;
import com.go2climb.app.tourist.resource.UpdateTouristResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class TouristMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public Tourist toModel(CreateTouristResource resource) { return this.mapper.map(resource, Tourist.class); }
    public Tourist toModel(UpdateTouristResource resource) {
        return this.mapper.map(resource, Tourist.class);
    }
    public TouristResource toResource(Tourist tourist) {
        return this.mapper.map(tourist, TouristResource.class);
    }
}
