package com.go2climb.app.activity.domain.service;

import com.go2climb.app.activity.domain.model.entity.Activity;

import java.util.List;
import java.util.Optional;

public interface ActivityService {
    List<Activity> getAll();
    Optional<Activity> getById(Integer id);
    Activity save(Activity activity);
    Activity update(Activity activity);
    boolean deleteById(Integer id);
}
