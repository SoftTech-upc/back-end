package com.go2climb.app.agency.domain.persistence;

import com.go2climb.app.agency.domain.model.entity.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, Integer> {
}
