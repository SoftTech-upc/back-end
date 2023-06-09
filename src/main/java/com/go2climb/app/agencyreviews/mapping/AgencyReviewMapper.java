package com.go2climb.app.agencyreviews.mapping;

import com.go2climb.app.agencyreviews.domain.model.entity.AgencyReview;
import com.go2climb.app.agencyreviews.resource.AgencyReviewResource;
import com.go2climb.app.agencyreviews.resource.CreateAgencyReviewResource;
import com.go2climb.app.agencyreviews.resource.UpdateAgencyReviewResource;
import com.go2climb.app.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class AgencyReviewMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;
    public AgencyReview toModel(CreateAgencyReviewResource resource){
        return this.mapper.map(resource, AgencyReview.class);
    }

    public AgencyReviewResource toResource(AgencyReview agencyReview){
        return this.mapper.map(agencyReview, AgencyReviewResource.class);
    }

    public AgencyReview toModel(UpdateAgencyReviewResource resource){
        return this.mapper.map(resource,AgencyReview.class);
    }
}
