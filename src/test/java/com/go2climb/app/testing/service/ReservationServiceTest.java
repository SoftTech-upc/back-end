package com.go2climb.app.testing.service;

import com.go2climb.app.reservation.domain.model.entity.Reservation;
import com.go2climb.app.reservation.domain.persistence.ReservationRepository;
import com.go2climb.app.reservation.service.ReservationServiceImpl;
import com.go2climb.app.tour.domain.model.entity.Tour;
import com.go2climb.app.tourist.domain.model.entity.Tourist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class ReservationServiceTest {
    @InjectMocks
    private ReservationServiceImpl reservationService;

    @Mock
    private ReservationRepository reservationRepository;

    @Mock
    private Tour tour;

    @Mock
    private Tourist tourist;

    @Test
    public void testGetAll() {
        Date now = new Date();
        Reservation reservation1 = new Reservation(1, 12, 1.2f, now, "Status",tour, tourist);
        Reservation reservation2 = new Reservation(2, 12, 1.2f, now, "Status",tour, tourist);

        when(reservationRepository.findAll()).thenReturn(List.of(reservation1, reservation2));

        List<Reservation> reservations = reservationService.fetchAll();

        assertEquals(2, reservations.size());
        assertEquals(reservation1, reservations.get(0));
        assertEquals(reservation2, reservations.get(1));

        verify(reservationRepository, times(1)).findAll();
    }

    @Test
    public void testGetById() {
        Date now = new Date();
        Reservation reservation = new Reservation(1, 12, 1.2f, now, "Status",tour, tourist);
        Mockito.when(reservationRepository.existsById(1)).thenReturn(true);
        Mockito.when(reservationRepository.findById(1)).thenReturn(Optional.of(reservation));

        Optional<Reservation> result = reservationService.fetchById(1);

        Assertions.assertEquals(reservation, result.get());

        Mockito.verify(reservationRepository, times(1)).existsById(1);
        Mockito.verify(reservationRepository, times(1)).findById(1);
    }

    @Test
    public void testSave() {
        Date now = new Date();
        Reservation expected = new Reservation(1, 12, 1.2f, now, "Status",tour, tourist);
        Reservation reservation = new Reservation(1, 12, 1.2f, now, "Status",tour, tourist);

        Mockito.when( reservationRepository.save(Mockito.any(Reservation.class)) )
                .thenReturn( reservation );

        Reservation actual = reservationService.save(new Reservation(1, 12, 1.2f, now, "Status",tour, tourist));

        Assertions.assertEquals(expected.getId(),actual.getId());
        Assertions.assertEquals(expected.getAmount(),actual.getAmount());
        Assertions.assertEquals(expected.getPrice(),actual.getPrice());
        Assertions.assertEquals(expected.getStatus(),actual.getStatus());
        Assertions.assertEquals(expected.getTour(),actual.getTour());
        Assertions.assertEquals(expected.getTourist(),actual.getTourist());
    }

    @Test
    public void testUpdate() {
        Date now = new Date();
        Reservation reservation = new Reservation(1, 12, 1.2f, now, "Status",tour, tourist);

        Mockito.when(reservationRepository.save(reservation)).thenReturn(reservation);

        Reservation result = reservationService.update(reservation);

        Assertions.assertEquals(reservation, result);

        Mockito.verify(reservationRepository, times(1)).save(reservation);
    }

    @Test
    public void testDeleteById() {
        Date now = new Date();
        // Simular el comportamiento del repositorio
        Reservation reservation = new Reservation(1, 12, 1.2f, now, "Status",tour, tourist);
        Mockito.when(reservationRepository.findById(1)).thenReturn(Optional.of(reservation));
        Mockito.doNothing().when(reservationRepository).deleteById(1);

        // Ejecutar el método a probar
        boolean result = reservationService.deleteById(1);

        // Verificar el resultado y las interacciones con el repositorio
        Assertions.assertTrue(result);
        Mockito.verify(reservationRepository).findById(1);
        Mockito.verify(reservationRepository).deleteById(1);
    }
}
