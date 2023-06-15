package com.go2climb.app.tour.resource;

import com.go2climb.app.agency.domain.model.entity.Agency;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTourResource {

    @NotNull
    @NotBlank
    @Min(1)
    private Integer id;

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
