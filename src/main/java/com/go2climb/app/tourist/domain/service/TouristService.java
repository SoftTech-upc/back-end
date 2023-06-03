package com.go2climb.app.tourist.domain.service;

import com.go2climb.app.tourist.domain.model.entity.Tourist;

import java.util.List;
import java.util.Optional;

public interface TouristService {
    List<Tourist> getAll();
    Optional<Tourist> getById(Integer id);
    Tourist save(Tourist tourist);
    Tourist update(Tourist tourist);
    boolean deleteById(Integer id);
}
