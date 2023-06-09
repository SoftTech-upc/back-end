package com.go2climb.app.reservation.service;

import com.go2climb.app.reservation.domain.model.entity.Reservation;
import com.go2climb.app.reservation.domain.persistence.ReservationRepository;
import com.go2climb.app.reservation.domain.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {
  @Autowired
  private ReservationRepository reservationRepository;

  @Transactional(readOnly = true)
  @Override
  public List<Reservation> fetchAll() {
    return reservationRepository.findAll();
  }

  @Transactional(readOnly = true)
  @Override
  public Optional<Reservation> fetchById(Integer id) {
    if (reservationRepository.existsById(id)) {
      return reservationRepository.findById(id);
    } else {
      return Optional.empty();
    }
  }

  @Transactional
  @Override
  public Reservation save(Reservation reservation) {
    return reservationRepository.save(reservation);
  }

  @Transactional
  @Override
  public Reservation update(Reservation reservation) {
    return reservationRepository.save(reservation);
  }

  @Transactional
  @Override
  public boolean deleteById(Integer id) {
    if (reservationRepository.existsById(id)) {
      reservationRepository.deleteById(id);
      return true;
    }
    return false;
  }
}
