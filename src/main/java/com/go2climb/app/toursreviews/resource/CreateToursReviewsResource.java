package com.go2climb.app.toursreviews.resource;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Setter
@Getter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateToursReviewsResource {
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @NotNull
    @NotBlank
    @Size(min =1,max = 1000)
    private String comment;
    @Min(0)
    @Max(5)
    @NotNull
    private Long score;
    @NotNull
    private Integer tourId;
    @NotNull
    private Integer touristId;
}
