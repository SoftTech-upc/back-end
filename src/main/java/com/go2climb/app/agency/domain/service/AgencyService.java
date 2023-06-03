package com.go2climb.app.agency.domain.service;

import com.go2climb.app.agency.domain.model.entity.Agency;

import java.util.List;
import java.util.Optional;

public interface AgencyService {
    List<Agency> getAll();
    Optional<Agency> getById(Integer id);
    Agency save(Agency Agency);
    Agency update(Agency Agency);
    boolean deleteById(Integer id);
}
