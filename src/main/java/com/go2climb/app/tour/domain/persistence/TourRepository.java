package com.go2climb.app.tour.domain.persistence;

import com.go2climb.app.tour.domain.model.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRepository extends JpaRepository<Tour, Integer> {
}
