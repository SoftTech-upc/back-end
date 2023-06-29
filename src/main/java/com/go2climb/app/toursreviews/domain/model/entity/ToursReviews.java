package com.go2climb.app.toursreviews.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.go2climb.app.tour.domain.model.entity.Tour;
import com.go2climb.app.tourist.domain.model.entity.Tourist;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Setter
@Getter
@Table(name ="tours_reviews" )//la numenclatura no debe ir mayusculas
@Entity
public class ToursReviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name="date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date date;
    @NotNull
    @NotBlank // no para numericos
    @Size(min =1,max = 1000)
    @Column(name="comment",length = 1000,nullable = false)
    private String comment;
    @NotNull
    @Column(name="score")
    private Long score;

    @JsonIgnoreProperties({"tourReviews"})
    @ManyToOne()
    @JoinColumn(name = "tourist_id")
    private Tourist tourist;

    @JsonIgnoreProperties({"reviews"})
    @ManyToOne()
    @JoinColumn(name = "tour_id")
    private Tour tour;
}
