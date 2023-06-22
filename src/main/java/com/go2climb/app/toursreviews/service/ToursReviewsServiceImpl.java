package com.go2climb.app.toursreviews.service;


import com.go2climb.app.toursreviews.domain.model.entity.ToursReviews;
import com.go2climb.app.toursreviews.domain.persistence.ToursReviewsRepository;
import com.go2climb.app.toursreviews.domain.service.ToursReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ToursReviewsServiceImpl implements ToursReviewsService {

    @Autowired
   private ToursReviewsRepository toursReviewsRepository;
    @Transactional(readOnly = true)
    @Override
    public List<ToursReviews> getAll() {
        return toursReviewsRepository.findAll();
    }
    @Transactional(readOnly = true)
    @Override
    public Optional<ToursReviews> getById(Integer Id) {
        if (toursReviewsRepository.existsById(Id)){
            return toursReviewsRepository.findById(Id);
        }
       else{
           return Optional.empty();
        }
    }
    @Transactional
    @Override
    public ToursReviews Save(ToursReviews toursReviews) {

        return toursReviewsRepository.save(toursReviews);
    }
    @Transactional
    @Override
    public ToursReviews Update(ToursReviews toursReviews) {
        return toursReviewsRepository.save(toursReviews);
    }
    @Transactional
    @Override
    public boolean deleteById(Integer Id) {

       if(toursReviewsRepository.existsById(Id)){
           toursReviewsRepository.deleteById(Id);
           return true;
       }
        else
       {
           return  false;
       }
    }
}
