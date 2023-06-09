package com.go2climb.app.agencyreviews.domain.service;

import com.go2climb.app.agencyreviews.domain.model.entity.AgencyReview;

import java.util.List;
import java.util.Optional;

public interface AgencyReviewService {
    List<AgencyReview> fetchAll();
    Optional<AgencyReview> fecthById(Integer id);
    AgencyReview save(AgencyReview agencyReview);
    AgencyReview update(AgencyReview agencyReview);
    boolean deleteById(Integer id);

    List<AgencyReview> fetchAllSecurityScore(Integer securityScore);
}
