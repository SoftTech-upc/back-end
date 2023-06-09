package com.go2climb.app.reservation.domain.persistence;

import com.go2climb.app.reservation.domain.model.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
