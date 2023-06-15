package com.go2climb.app.reservation.domain.model.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.go2climb.app.tour.domain.model.entity.Tour;
import com.go2climb.app.tourist.domain.model.entity.Tourist;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Min(1)
    @NotNull
    @Column(name = "amount", length = 9, nullable = false)
    private Integer amount;

    @Min(0)
    @NotNull
    @Column(name = "price", nullable = false)
    private Float price;

    @Future
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "schedule_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date scheduledDate;

    @Size(min = 1, max = 20)
    @NotNull
    @Column(name = "status", length = 20, nullable = false)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tour_id")
    @JsonIgnoreProperties({"agency", "activities", "reservations"})
    private Tour tour;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tourist_id")
    @JsonIgnoreProperties("reservations")
    private Tourist tourist;
}
