package com.go2climb.app.tourist.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.go2climb.app.activity.domain.model.entity.Activity;
import com.go2climb.app.agencyreviews.domain.model.entity.AgencyReview;
import com.go2climb.app.reservation.domain.model.entity.Reservation;
import com.go2climb.app.toursreviews.domain.model.entity.ToursReviews;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tourists")
public class Tourist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 1, max = 300)
    @NotNull
    @Column(name = "name", length = 300, nullable = false, unique = true)
    private String name;

    @Size(min = 1, max = 300)
    @NotNull
    @Column(name = "last_name", length = 300, nullable = false, unique = true)
    private String lastName;

    @Size(min = 1, max = 300)
    @NotNull
    @Column(name = "email", length = 300, nullable = false, unique = true)
    private String email;

    @Size(min = 9, max = 9)
    @NotNull
    @Column(name = "phone_number", length = 9, nullable = false)
    private String phoneNumber;

    @Size(min = 1, max = 300)
    @NotNull
    @Column(name = "password", length = 300, nullable = false)
    private String password;

    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "photo", length = 500, nullable = false)
    private String photo;

    @JsonIgnoreProperties({"tourist"})
    @OneToMany(mappedBy = "tourist", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    @JsonIgnoreProperties({"tourist"})
    @OneToMany(mappedBy = "tourist", cascade = CascadeType.ALL)
    private List<AgencyReview> agencyReviews;

    @JsonIgnoreProperties({"tourist"})
    @OneToMany(mappedBy = "tourist", cascade = CascadeType.ALL)
    private List<ToursReviews> tourReviews;

    @Column(name = "type")
    private String type="Tourist";
}