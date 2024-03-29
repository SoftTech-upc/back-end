package com.go2climb.app.tour.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.go2climb.app.activity.domain.model.entity.Activity;
import com.go2climb.app.agency.domain.model.entity.Agency;
import com.go2climb.app.reservation.domain.model.entity.Reservation;
import com.go2climb.app.toursreviews.domain.model.entity.ToursReviews;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tours")
@AllArgsConstructor
@NoArgsConstructor
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
    private Double score = 0.0;

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

    @CreationTimestamp
    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime creationDate;

    @PreUpdate
    protected void onUpdate() {
        creationDate = LocalDateTime.now();
    }

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

    @JsonIgnoreProperties({"tours"})
    @ManyToOne()
    @JoinColumn(name = "agency_id")
    private Agency agency;

    @JsonIgnoreProperties({"tour"})
    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL)
    private List<Activity> activities;

    @JsonIgnoreProperties({"tour"})
    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    @JsonIgnoreProperties({"tour"})
    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL)
    private List<ToursReviews> reviews;
}
