package com.go2climb.app.agency.domain.persistence;

import com.go2climb.app.agency.domain.model.entity.Agency;
import com.go2climb.app.tourist.domain.model.entity.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, Integer> {
    Optional<Agency> findOneByEmail(String email);
}
