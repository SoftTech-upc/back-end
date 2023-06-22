package com.example.SoftTech.resource;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class UpdateToursReviewsResource {

    @NotNull
    @Min(1)
    private Integer id;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @NotNull
    @NotBlank // no para numericos
    @Size(min =1,max = 1000)
    private String comment;
    @NotNull
    private Long score;
}
