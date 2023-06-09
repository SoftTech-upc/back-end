package com.go2climb.app.toursreviews.domain.service;

import com.go2climb.app.toursreviews.domain.model.entity.ToursReviews;

import java.util.Optional;
import java.util.List;
public interface ToursReviewsService {
    List<ToursReviews> getAll();
    Optional<ToursReviews> getById(Integer Id);
    ToursReviews Save(ToursReviews toursReviews);
    ToursReviews Update(ToursReviews toursReviews);

    boolean  deleteById(Integer Id);

}
