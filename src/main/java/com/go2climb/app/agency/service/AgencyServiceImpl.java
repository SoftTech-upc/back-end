package com.go2climb.app.agency.service;

import com.go2climb.app.agency.domain.model.entity.Agency;
import com.go2climb.app.agency.domain.persistence.AgencyRepository;
import com.go2climb.app.agency.domain.service.AgencyService;
import com.go2climb.app.agencyreviews.domain.model.entity.AgencyReview;
import com.go2climb.app.agencyreviews.domain.persistence.AgencyReviewRepository;
import com.go2climb.app.tourist.domain.model.entity.Tourist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AgencyServiceImpl implements AgencyService {

    @Autowired
    private AgencyRepository agencyRepository;

    @Autowired
    private AgencyReviewRepository agencyReviewRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Agency> getAll() {
        return agencyRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Agency> getById(Integer id) {
        if (agencyRepository.existsById(id)) {
            return agencyRepository.findById(id);
        } else {
            return Optional.empty();
        }
    }

    @Transactional
    @Override
    public Agency save(Agency agency) {
        return agencyRepository.save(agency);
    }

    @Transactional
    @Override
    public Agency update(Agency agency) {
        agency.setScore(agencyReviewRepository.calculateAverageProfessionalismScoreByAgencyId(agency.getId()));
        return agencyRepository.save(agency);
    }

    @Transactional
    @Override
    public boolean deleteById(Integer id) {
        if (agencyRepository.existsById(id)) {
            agencyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Agency> getByEmail(String name) {
        if (agencyRepository.findOneByEmail(name).isPresent()) {
            return agencyRepository.findOneByEmail(name);
        } else {
            return Optional.empty();
        }
    }
}
