package com.go2climb.app.tour.resource;

import com.go2climb.app.activity.domain.model.entity.Activity;
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
public class TourResource {
    private Integer id;
    private String name;
    private Float score;
    private Float price;
    private Float newPrice;
    private String location;
    private Date creationDate;
    private String photo;
    private String description;
    private Boolean isOffer;
}
