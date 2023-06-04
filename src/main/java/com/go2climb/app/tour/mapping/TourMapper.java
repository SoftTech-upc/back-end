package com.go2climb.app.tour.mapping;

import com.go2climb.app.tour.domain.model.entity.Tour;
import com.go2climb.app.tour.resource.TourResource;
import com.go2climb.app.tour.resource.CreateTourResource;
import com.go2climb.app.tour.resource.UpdateTourResource;
import com.go2climb.app.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class TourMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public Tour toModel(CreateTourResource resource) { return this.mapper.map(resource, Tour.class); }
    public Tour toModel(UpdateTourResource resource) {
        return this.mapper.map(resource, Tour.class);
    }
    public TourResource toResource(Tour tour) {
        return this.mapper.map(tour, TourResource.class);
    }
}
