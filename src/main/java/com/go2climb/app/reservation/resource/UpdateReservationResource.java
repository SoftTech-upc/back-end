package com.go2climb.app.reservation.resource;

import com.go2climb.app.tour.domain.model.entity.Tour;
import com.go2climb.app.tourist.domain.model.entity.Tourist;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class UpdateReservationResource {
  @NotNull
  @NotBlank
  @Min(1)
  private Integer id;

  @Min(1)
  @NotNull
  private Integer amount;

  @Min(0)
  @NotNull
  private Float price;

  @Future
  @NotNull
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date scheduledDate;

  @Size(min = 1, max = 20)
  @NotNull
  private String status;

  //@NotNull
  private Tourist tourist;

  //@NotNull
  private Tour tour;
}
