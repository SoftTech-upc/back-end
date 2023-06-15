package com.go2climb.app.toursreviews.mapping;


import com.go2climb.app.shared.mapping.EnhancedModelMapper;
import com.go2climb.app.toursreviews.domain.model.entity.ToursReviews;
import com.go2climb.app.toursreviews.resource.CreateToursReviewsResource;
import com.go2climb.app.toursreviews.resource.ToursReviewsResource;
import com.go2climb.app.toursreviews.resource.UpdateToursReviewsResource;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class ToursReviewsMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public ToursReviews toModel(CreateToursReviewsResource resource) {
        this.mapper.addMappings(new PropertyMap<CreateToursReviewsResource, ToursReviews>() {
            protected void configure() {
                map().setId(source.getTourId());
            }
        });
        return this.mapper.map(resource, ToursReviews.class);
    }

    public ToursReviewsResource toResource(ToursReviews agencyReview) {
        return this.mapper.map(agencyReview, ToursReviewsResource.class);
    }

    public ToursReviews toModel(UpdateToursReviewsResource resource){
        return this.mapper.map(resource,ToursReviews.class);
    }

}
