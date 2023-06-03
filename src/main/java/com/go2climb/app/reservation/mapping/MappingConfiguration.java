package com.go2climb.app.reservation.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("learningMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public ReservationMapper studentMapper() {
        return new ReservationMapper();
    }
}
