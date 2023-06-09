package com.go2climb.app.agencyreviews.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.ALWAYS)
public class Tourist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 1, max = 300)
    @NotNull
    @Column(name = "name", length = 300, nullable = false)
    private String name;

    @Size(min = 1, max = 300)
    @NotNull
    @Column(name = "last_name", length = 300, nullable = false)
    private String lastName;

    @Size(min = 1, max = 300)
    @NotNull
    @Column(name = "email", length = 300, nullable = false)
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

    //@JsonIgnoreProperties("tourist")
    @OneToMany(mappedBy = "tourist", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    //@JsonManagedReference
    private List<AgencyReview> agencyReviews;
}