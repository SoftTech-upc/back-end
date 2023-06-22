package com.go2climb.app.agencyreviews.domain.persistence;

import com.go2climb.app.agencyreviews.domain.model.entity.AgencyReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgencyReviewRepository extends JpaRepository<AgencyReview, Integer> {
    List<AgencyReview> findBySecurityScore(Integer securityScore);
}
