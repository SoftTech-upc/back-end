package com.go2climb.app.agency.resource;

import com.go2climb.app.tour.domain.model.entity.Tour;
import lombok.*;

import java.util.List;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class AgencyResource {

    private Integer id;
    private String name;
    private String email;
    private String phoneNumber;
    private String description;
    private String location;
    private String ruc;
    private String photo;
    private Float score;
}
