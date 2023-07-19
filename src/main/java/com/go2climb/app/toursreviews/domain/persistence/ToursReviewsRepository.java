package com.go2climb.app.toursreviews.domain.persistence;


import com.go2climb.app.toursreviews.domain.model.entity.ToursReviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ToursReviewsRepository extends JpaRepository <ToursReviews, Integer >{
    @Query("SELECT AVG(tr.score) FROM ToursReviews tr WHERE tr.tour.id = :tourId")
    Double calculateAverageScoreByTourId(@Param("tourId") Integer tourId);
}
