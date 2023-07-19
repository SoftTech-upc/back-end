package com.go2climb.app.agency.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.go2climb.app.agencyreviews.domain.model.entity.AgencyReview;
import com.go2climb.app.tour.domain.model.entity.Tour;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "agencies")
@AllArgsConstructor
@NoArgsConstructor
public class Agency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 1, max = 300)
    @NotNull
    @Column(name = "name", length = 300, nullable = false)
    private String name;

    @Size(min = 1, max = 300)
    @NotNull
    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Size(min = 9, max = 9)
    @NotNull
    @Column(name = "phone_number", length = 9, nullable = false)
    private String phoneNumber;

    @Size(min = 1, max = 300)
    @NotNull
    @Column(name = "description", length = 200, nullable = false)
    private String description;

    @Size(min = 1, max = 300)
    @NotNull
    @Column(name = "location", length = 200, nullable = false)
    private String location;

    @Size(min = 11, max = 11)
    @NotNull
    @Column(name = "ruc", length = 11, nullable = false)
    private String ruc;

    @Size(min = 1, max = 500)
    @NotNull
    @Column(name = "photo", length = 500)
    private String photo;


    @Column(name = "score", nullable = false)
    private Double score = 0.0;

    @JsonIgnoreProperties({"agency"})
    @OneToMany(mappedBy = "agency", cascade = CascadeType.ALL)
    private List<AgencyReview> reviews;

    @JsonIgnoreProperties({"agency"})
    @OneToMany(mappedBy = "agency", cascade = CascadeType.ALL)
    private List<Tour> tours;

    @Size(min = 1, max = 300)
    @NotNull
    @Column(name = "password", length = 300, nullable = false)
    private String password;

    @Column(name = "type")
    private String type="Agency";
}
