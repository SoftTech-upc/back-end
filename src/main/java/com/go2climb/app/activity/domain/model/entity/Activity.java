package com.go2climb.app.activity.domain.model.entity;

import com.go2climb.app.tour.model.entity.Tour;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "activities")
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tour_id", nullable = false)
    private Tour tour;
}

