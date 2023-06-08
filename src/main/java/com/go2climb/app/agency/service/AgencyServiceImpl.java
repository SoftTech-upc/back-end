package com.go2climb.app.agency.service;

import com.go2climb.app.agency.domain.model.entity.Agency;
import com.go2climb.app.agency.domain.persistence.AgencyRepository;
import com.go2climb.app.agency.domain.service.AgencyService;
import com.go2climb.app.shared.exception.ResourceNotFoundException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AgencyServiceImpl implements AgencyService {

    @Autowired
    private AgencyRepository agencyRepository;

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
