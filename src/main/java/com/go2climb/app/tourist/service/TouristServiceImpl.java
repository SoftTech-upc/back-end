package com.go2climb.app.tourist.service;

import com.go2climb.app.shared.exception.ResourceNotFoundException;
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
            throw new ResourceNotFoundException("Tourist", id);
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
