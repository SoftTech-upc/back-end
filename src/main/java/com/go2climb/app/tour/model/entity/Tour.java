package com.go2climb.app.tour.model.entity;

import com.go2climb.app.activity.domain.model.entity.Activity;
import com.go2climb.app.reservation.domain.model.entity.Reservation;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
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
    private Float score;

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
    @Column(name = "creation_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    
    @Size(min = 1, max = 500)
    @Column(name = "photo", length = 500)
    private String photo;

    @Size(min = 1, max = 250)
    @NotNull
    @Column(name = "description", length = 250, nullable = false)
    private String description;

    @Column(name = "is_offer", nullable = false)
    private Boolean isOffer;

    @OneToMany(mappedBy = "tour")
    private ArrayList<Activity> activities;

    @OneToMany(mappedBy = "tour")
    private List<Reservation> reservation;
}
