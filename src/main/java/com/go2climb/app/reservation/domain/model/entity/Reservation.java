package com.go2climb.app.reservation.domain.model.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.go2climb.app.tour.domain.model.entity.Tour;
import com.go2climb.app.tourist.domain.model.entity.Tourist;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "reservations")
@AllArgsConstructor
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

    @JsonIgnoreProperties({"reservations", "reviews"})
    @ManyToOne()
    @JoinColumn(name = "tour_id")
    private Tour tour;

    @JsonIgnoreProperties({"reservations", "agencyReviews", "toursReviews"})
    @ManyToOne()
    @JoinColumn(name = "tourist_id")
    private Tourist tourist;
}
