package com.go2climb.app.tour.service;

import com.go2climb.app.shared.exception.ResourceNotFoundException;
import com.go2climb.app.shared.exception.ResourceValidationException;
import com.go2climb.app.tour.domain.model.entity.Tour;
import com.go2climb.app.tour.domain.persistence.TourRepository;
import com.go2climb.app.tour.domain.service.TourService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.go2climb.app.shared.constant.Constant.TOUR_ENTITY;

@Service
public class TourServiceImpl implements TourService {
    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private Validator validator;

    @Transactional(readOnly = true)
    @Override
    public List<Tour> getAll() {
        return tourRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Tour> getById(Integer id) {
        if (tourRepository.existsById(id)) {
            return tourRepository.findById(id);
        } else {
            throw new ResourceNotFoundException("Tour", id);
        }
    }

    @Transactional
    @Override
    public Tour save(Tour tour) {
        Set<ConstraintViolation<Tour>> violations = validator.validate(tour);
        if(!violations.isEmpty()) {
            throw new ResourceValidationException(TOUR_ENTITY, violations);
        }
        return tourRepository.save(tour);
    }

    @Transactional
    @Override
    public Tour update(Tour tour) {
        return tourRepository.save(tour);
    }

    @Transactional
    @Override
    public boolean deleteById(Integer id) {
        if (tourRepository.existsById(id)) {
            tourRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
