package com.go2climb.app.agency.resource;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAgencyResource {
    @NotNull
    @NotBlank
    @Min(1)
    private Integer id;

    @Size(min = 1, max = 30)
    //@NotNull
    private String name;

    @Size(min = 1, max = 100)
    //@NotNull
    private String email;

    @Size(min = 9, max = 9)
    //@NotNull
    private String phoneNumber;

    @Size(min = 1, max = 200)
    //@NotNull
    private String description;

    @Size(min = 1, max = 200)
    //@NotNull
    private String location;

    @Size(min = 0, max = 5)
    private Float score;

    @Size(min = 11, max = 11)
    //@NotNull
    private String ruc;

    @Size(min = 1, max = 500)
    private String photo;

    @Size(min = 1, max = 25)
    @NotNull
    private String password;
}
