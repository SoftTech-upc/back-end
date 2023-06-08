package com.go2climb.app.tour.domain.service;

import com.go2climb.app.tour.domain.model.entity.Tour;

import java.util.List;
import java.util.Optional;

public interface TourService {
    List<Tour> getAll();
    Optional<Tour> getById(Integer id);
    Tour save(Tour tour);
    Tour update(Tour tour);
    boolean deleteById(Integer id);
}
