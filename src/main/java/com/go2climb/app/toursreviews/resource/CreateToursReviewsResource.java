package com.go2climb.app.toursreviews.resource;

import com.go2climb.app.tour.domain.model.entity.Tour;
import com.go2climb.app.tourist.domain.model.entity.Tourist;
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
    @NotBlank // no para numericos
    @Size(min =1,max = 1000)
    private String comment;
    @NotNull
    private Long score;
    @NotNull
    private Tourist tourist;
    @NotNull
    private Tour tours;
}
