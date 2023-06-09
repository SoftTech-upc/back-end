package com.go2climb.app.activity.domain.persistence;

import com.go2climb.app.activity.domain.model.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {
}
