package com.go2climb.app.reservation.domain.service;

import com.go2climb.app.reservation.domain.model.entity.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationService {
  List<Reservation> fetchAll();    // getAll, fetchAll, getStudents
  Optional<Reservation> fetchById(Integer id);
  Reservation save(Reservation student);
  Reservation update(Reservation student);
  boolean deleteById(Integer id);
}
