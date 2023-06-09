package com.go2climb.app.agencyreviews.resource;

//import com.example.TfOpen.domain.model.entity.Agency;

import com.go2climb.app.agencyreviews.domain.model.entity.Agency;
import com.go2climb.app.agencyreviews.domain.model.entity.Tourist;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@With
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAgencyReviewResource {

    @NotNull
    @Min(1)
    private  Integer id;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 1000)
    private String comment;

    @NotNull
    private Integer professionalismScore;

    @NotNull
    private Integer securityScore;

    @NotNull
    private Integer qualityScore;

    @NotNull
    private Integer costScore;

    @NotNull
    private Tourist tourist;

    @NotNull
    private Agency agency;
}
