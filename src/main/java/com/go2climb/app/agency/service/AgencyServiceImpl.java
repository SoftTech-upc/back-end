package com.go2climb.app.agency.service;

import com.go2climb.app.agency.domain.model.entity.Agency;
import com.go2climb.app.agency.domain.persistence.AgencyRepository;
import com.go2climb.app.agency.domain.service.AgencyService;
import com.go2climb.app.shared.exception.ResourceNotFoundException;
import com.go2climb.app.shared.exception.ResourceValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.go2climb.app.shared.constant.Constant.AGENCY_ENTITY;

@Service
public class AgencyServiceImpl implements AgencyService {

    @Autowired
    private AgencyRepository agencyRepository;

    @Autowired
    private Validator validator;

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
            throw new ResourceNotFoundException("Agency", id);
        }
    }

    @Transactional
    @Override
    public Agency save(Agency agency) {
        Set<ConstraintViolation<Agency>> violations = validator.validate(agency);
        if(!violations.isEmpty()) {
            throw new ResourceValidationException(AGENCY_ENTITY, violations);
        }
        return agencyRepository.save(agency);
    }

    @Transactional
    @Override
    public Agency update(Agency agency) {
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
}
