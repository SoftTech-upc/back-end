package com.go2climb.app.reservation.mapping;

import com.go2climb.app.reservation.domain.model.entity.Reservation;
import com.go2climb.app.reservation.resource.CreateReservationResource;
import com.go2climb.app.reservation.resource.ReservationResource;
import com.go2climb.app.reservation.resource.UpdateReservationResource;
import com.go2climb.app.shared.mapping.EnhancedModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class ReservationMapper implements Serializable {
  @Autowired
  EnhancedModelMapper mapper;

  public Reservation toModel(CreateReservationResource resource) {
    this.mapper.addMappings(new PropertyMap<CreateReservationResource, Reservation>() {
      protected void configure() {
        map().setId(source.getTourId());
      }
    });
    return this.mapper.map(resource, Reservation.class);
  }
  public Reservation toModel(UpdateReservationResource resource) {
    return this.mapper.map(resource, Reservation.class);
  }
  public ReservationResource toResource(Reservation reservation) {
    return this.mapper.map(reservation, ReservationResource.class);
  }
}
