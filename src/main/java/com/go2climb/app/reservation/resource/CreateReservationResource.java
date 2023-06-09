package com.go2climb.app.reservation.resource;

import com.go2climb.app.tour.domain.model.entity.Tour;
import com.go2climb.app.tourist.domain.model.entity.Tourist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateReservationResource {

  @Min(1)
  @NotNull
  private Integer amount;

  @Min(0)
  @NotNull
  private Float price;

  @Future
  @NotNull
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Temporal(TemporalType.DATE)
  private Date scheduledDate;

  @Size(min = 1, max = 20)
  @NotNull
  private String status;

  @NotNull
  private Tourist tourist;

  @NotNull
  private Tour tour;
}
