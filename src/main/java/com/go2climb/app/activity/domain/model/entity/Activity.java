package com.go2climb.app.activity.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.go2climb.app.tour.domain.model.entity.Tour;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "activities")
@AllArgsConstructor
@NoArgsConstructor
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 1, max = 75)
    @NotNull
    @Column(name = "name", length = 30, nullable = false)
    private String name;

    @Size(min = 1, max = 100)
    @NotNull
    @Column(name = "email", length = 100, nullable = false)
    private String description;

    @JsonIgnoreProperties({"activities"})
    @ManyToOne()
    @JoinColumn(name = "tour_id")
    private Tour tour;
}

