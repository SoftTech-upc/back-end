package com.go2climb.app.agencyreviews.service;

import com.go2climb.app.agency.domain.model.entity.Agency;
import com.go2climb.app.agency.domain.persistence.AgencyRepository;
import com.go2climb.app.agencyreviews.domain.model.entity.AgencyReview;
import com.go2climb.app.agencyreviews.domain.persistence.AgencyReviewRepository;
import com.go2climb.app.agencyreviews.domain.service.AgencyReviewService;
import com.go2climb.app.tourist.domain.model.entity.Tourist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AgencyReviewServiceImpl implements AgencyReviewService {

    @Autowired
    private AgencyReviewRepository agencyReviewRepository;

    @Autowired
    private AgencyRepository agencyRepository;

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
        AgencyReview response = agencyReviewRepository.save(agencyReview);
        Agency average = agencyRepository.getById(agencyReview.getAgency().getId());
        average.setScore(agencyReviewRepository.calculateAverageProfessionalismScoreByAgencyId(average.getId()));
        agencyRepository.save(average);
        return response;
    }

    @Transactional
    @Override
    public AgencyReview update(AgencyReview agencyReview) {
        return agencyReviewRepository.save(agencyReview);
    }

    @Transactional
    @Override
    public boolean deleteById(Integer id) {
        if (!agencyReviewRepository.existsById(id)) {
            return false;
        }
        agencyReviewRepository.deleteById(id);
        return true;
    }

    @Transactional(readOnly = true)
    @Override
    public List<AgencyReview> fetchAllSecurityScore(Integer securityScore) {
        return agencyReviewRepository.findBySecurityScore(securityScore);
    }
}
