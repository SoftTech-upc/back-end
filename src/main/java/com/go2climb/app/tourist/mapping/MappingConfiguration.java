package com.go2climb.app.tourist.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("touristMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public TouristMapper touristMapper() {
        return new TouristMapper();
    }
}
