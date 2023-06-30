package com.go2climb.app.activity.resource;

import com.go2climb.app.tour.domain.model.entity.Tour;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UpdateActivityResource {
    @NotNull
    @NotBlank
    @Min(1)
    private Integer id;

    @Size(min = 1, max = 75)
    @NotNull
    private String name;

    @Size(min = 1, max = 100)
    @NotNull
    private String description;

    @NotNull
    private Tour tour;
}
