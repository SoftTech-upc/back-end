package com.go2climb.app.reservation.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("reservationMappingConfiguration")
public class MappingConfiguration {

  @Bean
  public ReservationMapper reservationMapper() {
    return new ReservationMapper();
  }
}
