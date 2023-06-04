package com.go2climb.app.tour.resource;

import com.go2climb.app.activity.domain.model.entity.Activity;
import com.go2climb.app.agency.domain.model.entity.Agency;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateTourResource {

    @Size(min = 1, max = 25)
    @NotNull
    private String name;

    @NotNull
    @Min(0)
    private Float price;

    @Min(0)
    private Float newPrice;

    @Size(min = 1, max = 200)
    @NotNull
    private String location;

    @Past
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "photo", length = 500)
    private String photo;

    @Size(min = 1, max = 250)
    @NotNull
    private String description;

    @NotNull
    private Boolean isOffer;
}
