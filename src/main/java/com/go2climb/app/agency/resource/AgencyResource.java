package com.go2climb.app.agency.resource;

import lombok.*;

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
