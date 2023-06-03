package com.go2climb.app.agency.mapping;

import com.go2climb.app.agency.domain.model.entity.Agency;
import com.go2climb.app.agency.resource.AgencyResource;
import com.go2climb.app.agency.resource.CreateAgencyResource;
import com.go2climb.app.agency.resource.UpdateAgencyResource;
import com.go2climb.app.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class AgencyMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public Agency toModel(CreateAgencyResource resource) { return this.mapper.map(resource, Agency.class); }
    public Agency toModel(UpdateAgencyResource resource) {
        return this.mapper.map(resource, Agency.class);
    }
    public AgencyResource toResource(Agency agency) {
        return this.mapper.map(agency, AgencyResource.class);
    }
}
