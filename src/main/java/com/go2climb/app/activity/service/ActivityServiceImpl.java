package com.go2climb.app.activity.service;

import com.go2climb.app.activity.domain.service.ActivityService;
import com.go2climb.app.activity.domain.model.entity.Activity;
import com.go2climb.app.activity.domain.persistence.ActivityRepository;
import com.go2climb.app.shared.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Activity> getAll() {
        return activityRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Activity> getById(Integer id) {
        if (activityRepository.existsById(id)) {
            return activityRepository.findById(id);
        } else {
            throw new ResourceNotFoundException("Activity", id);
        }
    }

    @Transactional
    @Override
    public Activity save(Activity activity) {
        return activityRepository.save(activity);
    }

    @Transactional
    @Override
    public Activity update(Activity activity) {
        return activityRepository.save(activity);
    }

    @Transactional
    @Override
    public boolean deleteById(Integer id) {
        if (activityRepository.existsById(id)) {
            activityRepository.deleteById(id);
            return true;
        }
        return false;
    }
}