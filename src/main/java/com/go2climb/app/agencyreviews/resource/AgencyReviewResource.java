package com.go2climb.app.agencyreviews.resource;

//import com.example.TfOpen.domain.model.entity.Agency;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.go2climb.app.agency.domain.model.entity.Agency;
import com.go2climb.app.tourist.domain.model.entity.Tourist;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
