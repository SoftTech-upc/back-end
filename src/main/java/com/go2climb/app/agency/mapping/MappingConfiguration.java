package com.go2climb.app.agency.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("agencyMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public AgencyMapper agencyMapper() {
        return new AgencyMapper();
    }
}
