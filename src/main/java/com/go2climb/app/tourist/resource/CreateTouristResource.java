package com.go2climb.app.tourist.resource;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateTouristResource {

    @Size(min = 1, max = 50)
    @NotNull
    private String name;
    @Size(min = 1, max = 75)
    @NotNull
    private String lastName;

    @Size(min = 1, max = 250)
    @NotNull
    private String email;

    @Size(min = 9, max = 9)
    @NotNull
    private String phoneNumber;

    @Size(min = 1, max = 25)
    @NotNull
    private String password;

    @NotNull
    @Size(min = 1, max = 500)
    private String photo;
}
