package com.go2climb.app.tourist.resource;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTouristResource {
    @NotNull
    @NotBlank
    @Min(1)
    private Integer id;

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
