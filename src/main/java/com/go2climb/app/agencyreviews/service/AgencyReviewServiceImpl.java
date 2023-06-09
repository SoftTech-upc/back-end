package com.go2climb.app.agencyreviews.service;

import com.go2climb.app.agencyreviews.domain.model.entity.AgencyReview;
import com.go2climb.app.agencyreviews.domain.persistence.AgencyReviewRepository;
import com.go2climb.app.agencyreviews.domain.service.AgencyReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AgencyReviewServiceImpl implements AgencyReviewService {

    @Autowired
    private AgencyReviewRepository agencyReviewRepository;

    @Transactional(readOnly= true)
    @Override
    public List<AgencyReview> fetchAll() {
        return agencyReviewRepository.findAll();
    }

    @Transactional(readOnly= true)
    @Override
    public Optional<AgencyReview> fecthById(Integer id) {
        if (agencyReviewRepository.existsById(id)) {
            return agencyReviewRepository.findById(id);
        } else {
            return Optional.empty();
        }
    }

    @Transactional
    @Override
    public AgencyReview save(AgencyReview agencyReview) {
        return agencyReviewRepository.save(agencyReview);
    }

    @Transactional
    @Override
    public AgencyReview update(AgencyReview agencyReview) {
        return agencyReviewRepository.save(agencyReview);
    }

    @Transactional
    @Override
    public boolean deleteById(Integer id) {
        if (agencyReviewRepository.existsById(id)) {
            agencyReviewRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Transactional(readOnly = true)
    @Override
    public List<AgencyReview> fetchAllSecurityScore(Integer securityScore) {
        return agencyReviewRepository.findBySecurityScore(securityScore);
    }
}
