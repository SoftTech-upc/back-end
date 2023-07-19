package com.go2climb.app.agency.domain.service;

import com.go2climb.app.agency.domain.model.entity.Agency;
import com.go2climb.app.tourist.domain.model.entity.Tourist;

import java.util.List;
import java.util.Optional;

public interface AgencyService {
    List<Agency> getAll();
    Optional<Agency> getById(Integer id);
    Agency save(Agency agency);
    Agency update(Agency agency);
    boolean deleteById(Integer id);
    Optional<Agency> getByEmail(String id);
}
