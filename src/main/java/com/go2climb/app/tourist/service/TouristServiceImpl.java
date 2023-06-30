package com.go2climb.app.tourist.service;

import com.go2climb.app.agency.domain.persistence.AgencyRepository;
import com.go2climb.app.tourist.domain.model.entity.Tourist;
import com.go2climb.app.tourist.domain.persistence.TouristRepository;
import com.go2climb.app.tourist.domain.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TouristServiceImpl implements TouristService {
    @Autowired
    private TouristRepository touristRepository;

    @Autowired
    private AgencyRepository agencyRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Tourist> getAll() {
        return touristRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Tourist> getById(Integer id) {
        if (touristRepository.existsById(id)) {
            return touristRepository.findById(id);
        } else {
            return Optional.empty();
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Tourist> getByEmail(String name) {
        if (touristRepository.findOneByEmail(name).isPresent()) {
            return touristRepository.findOneByEmail(name);
        } else {
            return Optional.empty();
        }
    }

    @Transactional
    @Override
    public Tourist save(Tourist tourist) {
        return touristRepository.save(tourist);
    }

    @Transactional
    @Override
    public Tourist update(Tourist tourist) {
        return touristRepository.save(tourist);
    }

    @Transactional
    @Override
    public boolean deleteById(Integer id) {
        if (touristRepository.existsById(id)) {
            touristRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
