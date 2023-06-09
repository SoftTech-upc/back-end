package com.go2climb.app.agencyreviews.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("learningMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public AgencyReviewMapper agencyReviewMapper(){
        return new AgencyReviewMapper();
    }
}
