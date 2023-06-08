package com.go2climb.app.tour.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("tourMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public TourMapper tourMapper() {
        return new TourMapper();
    }
}
