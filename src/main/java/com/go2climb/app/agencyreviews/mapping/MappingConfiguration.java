package com.go2climb.app.agencyreviews.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("AgencyReviewMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public AgencyReviewMapper agencyReviewMapper(){
        return new AgencyReviewMapper();
    }
}
