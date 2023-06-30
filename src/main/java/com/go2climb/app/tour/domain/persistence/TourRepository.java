package com.go2climb.app.tour.domain.persistence;

import com.go2climb.app.tour.domain.model.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourRepository extends JpaRepository<Tour, Integer> {
    @Query("SELECT t FROM Tour t WHERE t.isOffer = true")
    List<Tour> findOfferTours();
}
