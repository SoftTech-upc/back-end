package com.go2climb.app.tourist.domain.persistence;

import com.go2climb.app.tourist.domain.model.entity.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TouristRepository extends JpaRepository<Tourist, Integer> {
}
