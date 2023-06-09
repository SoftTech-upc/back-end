package com.go2climb.app.toursreviews.domain.persistence;

import com.go2climb.app.toursreviews.domain.model.entity.ToursReviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface   ToursReviewsRepository extends JpaRepository <ToursReviews, Integer >{


}
