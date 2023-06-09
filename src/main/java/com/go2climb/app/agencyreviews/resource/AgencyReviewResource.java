package com.go2climb.app.agencyreviews.resource;

//import com.example.TfOpen.domain.model.entity.Agency;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class AgencyReviewResource {

    private Integer id;

    private LocalDateTime createdAt;

    private String comment;

    private Integer professionalismScore;

    private Integer securityScore;

    private Integer qualityScore;

    private Integer costScore;
}
