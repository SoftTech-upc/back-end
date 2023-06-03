package com.go2climb.app.reservation.resource;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ReservationResource {

    private Integer id;
    private Integer amount;
    private Float price;
    private Date scheduledDate;
    private String status;
}
