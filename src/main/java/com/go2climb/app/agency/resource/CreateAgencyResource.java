package com.go2climb.app.agency.resource;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateAgencyResource {

    @Size(min = 1, max = 30)
    @NotNull
    private String name;

    @Size(min = 1, max = 100)
    @NotNull
    private String email;

    @Size(min = 9, max = 9)
    @NotNull
    private String phoneNumber;

    @Size(min = 1, max = 200)
    @NotNull
    private String description;

    @Size(min = 1, max = 200)
    @NotNull
    private String location;

    @Size(min = 11, max = 11)
    @NotNull
    private String ruc;

    @Size(min = 1, max = 500)
    private String photo;
}
