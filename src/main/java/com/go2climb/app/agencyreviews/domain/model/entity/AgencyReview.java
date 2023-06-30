package com.go2climb.app.agencyreviews.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.go2climb.app.agency.domain.model.entity.Agency;
import com.go2climb.app.tourist.domain.model.entity.Tourist;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "agencies_reviews")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class AgencyReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CreationTimestamp
    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 1000)
    @Column(name = "comment", length = 50, nullable = false)
    private String comment;

    @Min(value = 0, message = "El puntaje de profesionalismo debe ser mayor o igual a 0")
    @Max(value = 5, message = "El puntaje de profesionalismo debe ser menor o igual a 5")
    @NotNull
    @Column(name = "professionalism_score")
    private Float professionalismScore;

    @NotNull
    @Column(name = "security_score")
    private Float securityScore;

    @NotNull
    @Column(name = "quality_score")
    private Integer qualityScore;

    @NotNull
    @Column(name = "cost_score")
    private Integer costScore;

    @PreUpdate
    protected void onUpdate() {
        createdAt = LocalDateTime.now();
    }

    @ManyToOne()
    @JoinColumn(name = "agency_id")
    @JsonIgnoreProperties("reviews")
    private Agency agency;

    @ManyToOne()
    @JoinColumn(name = "tourist_id")
    @JsonIgnoreProperties("agencyReviews")
    private Tourist tourist;
}
