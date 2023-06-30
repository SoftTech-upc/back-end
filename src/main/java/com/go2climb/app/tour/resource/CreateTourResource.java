package com.go2climb.app.tour.resource;

import com.go2climb.app.agency.domain.model.entity.Agency;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
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

    @CreationTimestamp
    @CreatedDate
    private LocalDateTime creationDate;

    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "photo", length = 500)
    private String photo;

    @Size(min = 1, max = 250)
    @NotNull
    private String description;

    @NotNull
    private Boolean isOffer;

    @NotNull
    private Agency agency;
}
