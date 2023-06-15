package com.go2climb.app.reservation.service;

import com.go2climb.app.reservation.domain.model.entity.Reservation;
import com.go2climb.app.reservation.domain.persistence.ReservationRepository;
import com.go2climb.app.reservation.domain.service.ReservationService;
import com.go2climb.app.shared.exception.ResourceNotFoundException;
import com.go2climb.app.shared.exception.ResourceValidationException;
import com.go2climb.app.tourist.domain.model.entity.Tourist;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.go2climb.app.shared.constant.Constant.RESERVATION_ENTITY;
import static com.go2climb.app.shared.constant.Constant.TOURIST_ENTITY;

@Service
public class ReservationServiceImpl implements ReservationService {
  @Autowired
  private ReservationRepository reservationRepository;

  @Autowired
  private Validator validator;

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
      throw new ResourceNotFoundException("Tourist", id);
    }
  }

  @Transactional
  @Override
  public Reservation save(Reservation reservation) {
    Set<ConstraintViolation<Reservation>> violations = validator.validate(reservation);
    if(!violations.isEmpty()) {
      throw new ResourceValidationException(RESERVATION_ENTITY, violations);
    }
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
