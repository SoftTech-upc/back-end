package com.go2climb.app.tour.service;

import com.go2climb.app.tour.domain.model.entity.Tour;
import com.go2climb.app.tour.domain.persistence.TourRepository;
import com.go2climb.app.tour.domain.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TourServiceImpl implements TourService {
    @Autowired
    private TourRepository tourRepository;

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
            return Optional.empty();
        }
    }

    @Transactional
    @Override
    public Tour save(Tour tour) {
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

    @Transactional(readOnly = true)
    @Override
    public List<Tour> getAllOffer() {
        return tourRepository.findOfferTours();
    }

    @Override
    public List<Tour> getOrderScoreDesc() {
        return tourRepository.findAllByOrderByScoreDesc();
    }
}
