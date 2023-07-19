package com.go2climb.app.agencyreviews.resource;

//import com.example.TfOpen.domain.model.entity.Agency;

import com.go2climb.app.agency.domain.model.entity.Agency;
import com.go2climb.app.tourist.domain.model.entity.Tourist;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Setter
@Getter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateAgencyReviewResource {

    @CreationTimestamp
    @CreatedDate
    private LocalDateTime createdAt;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 1000)
    private String comment;

    @NotNull
    private Float professionalismScore;

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
