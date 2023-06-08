package com.go2climb.app.tourist.domain.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tourists")
public class Tourist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 1, max = 50)
    @NotNull
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Size(min = 1, max = 75)
    @NotNull
    @Column(name = "last_name", length = 75, nullable = false)
    private String lastName;

    @Size(min = 1, max = 250)
    @NotNull
    @Column(name = "email", length = 250, nullable = false)
    private String email;

    @Size(min = 9, max = 9)
    @NotNull
    @Column(name = "phone_number", length = 9, nullable = false)
    private String phoneNumber;

    @Size(min = 1, max = 25)
    @NotNull
    @Column(name = "password", length = 25, nullable = false)
    private String password;

    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "photo", length = 500, nullable = false)
    private String photo;
}