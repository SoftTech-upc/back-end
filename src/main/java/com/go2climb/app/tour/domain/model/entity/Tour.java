package com.go2climb.app.tour.domain.model.entity;

import com.fasterxml.jackson.annotation.*;
import com.go2climb.app.activity.domain.model.entity.Activity;
import com.go2climb.app.agency.domain.model.entity.Agency;
import com.go2climb.app.reservation.domain.model.entity.Reservation;
import com.go2climb.app.toursreviews.domain.model.entity.ToursReviews;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.swing.text.View;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tours")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 1, max = 25)
    @NotNull
    @Column(name = "name", length = 25, nullable = false)
    private String name;

    @Min(0)
    @Max(5)
    @Column(name = "score", nullable = false)
    private Float score = 0f;

    @NotNull
    @Min(0)
    @Column(name = "price", nullable = false)
    private Float price;

    @Min(0)
    @Column(name = "new_price")
    private Float newPrice;

    @Size(min = 1, max = 200)
    @NotNull
    @Column(name = "location", length = 200, nullable = false)
    private String location;

    @Past
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "creation_date", nullable = false)
    private Date creationDate;

    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "photo", length = 500, nullable = false)
    private String photo;

    @Size(min = 1, max = 250)
    @NotNull
    @Column(name = "description", length = 250, nullable = false)
    private String description;

    @NotNull
    @Column(name = "is_offer", nullable = false)
    private Boolean isOffer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agency_id")
    @JsonIgnoreProperties("tours")
    private Agency agency;

    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("tour")
    private List<Activity> activities;

    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("tour")
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("tour")
    private List<ToursReviews> reviews;
}
