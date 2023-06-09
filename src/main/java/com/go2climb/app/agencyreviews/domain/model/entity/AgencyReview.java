package com.go2climb.app.agencyreviews.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotNull
    @Column(name = "professionalism_score")
    private Integer professionalismScore;

    @NotNull
    @Column(name = "security_score")
    private Integer securityScore;

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

    @JsonProperty()
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "agency_id")
    //@JsonBackReference
    private Agency agency;

    @JsonProperty()
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tourist_id")
    //@JsonBackReference
    private Tourist tourist;
}
