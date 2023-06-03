package com.go2climb.app.tourist.resource;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class TouristResource {

    private Integer id;
    private String name;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String photo;
}
