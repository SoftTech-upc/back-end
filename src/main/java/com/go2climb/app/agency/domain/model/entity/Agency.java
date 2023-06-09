package com.go2climb.app.agency.domain.model.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.go2climb.app.activity.domain.model.entity.Activity;
import com.go2climb.app.tour.domain.model.entity.Tour;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "agencies")
public class Agency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 1, max = 30)
    //@NotNull
    @Column(name = "name", length = 30, nullable = false)
    private String name;

    @Size(min = 1, max = 100)
    //@NotNull
    @Column(name = "email", length = 100)
    private String email;

    @Size(min = 9, max = 9)
    //@NotNull
    @Column(name = "phone_number", length = 9, nullable = false)
    private String phoneNumber;

    @Size(min = 1, max = 200)
    //@NotNull
    @Column(name = "description", length = 200, nullable = false)
    private String description;

    @Size(min = 1, max = 200)
    //@NotNull
    @Column(name = "location", length = 200, nullable = false)
    private String location;

    @Size(min = 11, max = 11)
    //@NotNull
    @Column(name = "ruc", length = 11, nullable = false)
    private String ruc;

    @Size(min = 1, max = 500)
    //@NotNull
    @Column(name = "photo", length = 500)
    private String photo;

    @Min(0)
    @Max(5)
    @Column(name = "score", nullable = false)
    private Float score = 0f;

    @OneToMany(mappedBy = "agency", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("agency")
    private List<Tour> tours;
}
