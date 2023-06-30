package com.go2climb.app.testing.service;

import com.go2climb.app.activity.domain.model.entity.Activity;
import com.go2climb.app.agency.domain.model.entity.Agency;
import com.go2climb.app.reservation.domain.model.entity.Reservation;
import com.go2climb.app.tour.domain.model.entity.Tour;
import com.go2climb.app.tour.domain.persistence.TourRepository;
import com.go2climb.app.tour.service.TourServiceImpl;
import com.go2climb.app.toursreviews.domain.model.entity.ToursReviews;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TourServiceTest {
    @InjectMocks
    private TourServiceImpl tourService;

    @Mock
    private TourRepository tourRepository;

    @Mock
    private Agency agency;

    @Mock
    private List<Reservation> reservations;

    @Mock
    private List<Activity> activities;

    @Mock
    private List<ToursReviews> toursReviews;

    @Test
    public void testGetAll() {
        LocalDateTime now = LocalDateTime.now();
        Tour tour1 = new Tour(1, "tour 1", 1.2, 500.0f, 400.0f, "peru", now, "image", "descripcion 1", true, agency, activities, reservations, toursReviews);
        Tour tour2 = new Tour(2, "tour 2", 1.2, 500.0f, 400.0f, "peru", now, "image", "descripcion 1", true, agency, activities, reservations, toursReviews);

        when(tourRepository.findAll()).thenReturn(List.of(tour1, tour2));

        List<Tour> tour = tourService.getAll();

        assertEquals(2, tour.size());
        assertEquals(tour1, tour.get(0));
        assertEquals(tour2, tour.get(1));

        verify(tourRepository, times(1)).findAll();
    }

    @Test
    public void testGetById() {
        LocalDateTime now = LocalDateTime.now();
        Tour reservation = new Tour(1, "tour 1", 1.2, 500.0f, 400.0f, "peru", now, "image", "descripcion 1", true, agency, activities, reservations, toursReviews);
        Mockito.when(tourRepository.existsById(1)).thenReturn(true);
        Mockito.when(tourRepository.findById(1)).thenReturn(Optional.of(reservation));

        Optional<Tour> result = tourService.getById(1);

        assertTrue(result.isPresent());
        Assertions.assertEquals(reservation, result.get());

        // Verificar que se llamó al método del repositorio
        Mockito.verify(tourRepository, times(1)).existsById(1);
        Mockito.verify(tourRepository, times(1)).findById(1);
    }

    @Test
    public void testSave() {
        LocalDateTime now = LocalDateTime.now();
        Tour expected = new Tour(1, "tour 1", 1.2, 500.0f, 400.0f, "peru", now, "image", "descripcion 1", true, agency, activities, reservations, toursReviews);
        Tour reservation = new Tour(1, "tour 1", 1.2, 500.0f, 400.0f, "peru", now, "image", "descripcion 1", true, agency, activities, reservations, toursReviews);

        Mockito.when( tourRepository.save(Mockito.any(Tour.class)) )
                .thenReturn( reservation );

        Tour actual = tourService.save(new Tour(1, "tour 1", 1.2, 500.0f, 400.0f, "peru", now, "image", "descripcion 1", true, agency, activities, reservations, toursReviews));

        Assertions.assertEquals(expected.getId(),actual.getId());
        Assertions.assertEquals(expected.getName(),actual.getName());
        Assertions.assertEquals(expected.getScore(),actual.getScore());
        Assertions.assertEquals(expected.getPrice(),actual.getPrice());
        Assertions.assertEquals(expected.getNewPrice(),actual.getNewPrice());
        Assertions.assertEquals(expected.getLocation(),actual.getLocation());
        Assertions.assertEquals(expected.getCreationDate(),actual.getCreationDate());
        Assertions.assertEquals(expected.getPhoto(),actual.getPhoto());
        Assertions.assertEquals(expected.getDescription(),actual.getDescription());
        Assertions.assertEquals(expected.getIsOffer(),actual.getIsOffer());
    }

    @Test
    public void testUpdate() {
        LocalDateTime now = LocalDateTime.now();
        Tour reservation = new Tour(1, "tour 1", 1.2, 500.0f, 400.0f, "peru", now, "image", "descripcion 1", true, agency, activities, reservations, toursReviews);

        Mockito.when(tourRepository.save(reservation)).thenReturn(reservation);

        Tour result = tourService.update(reservation);

        Assertions.assertEquals(reservation, result);

        Mockito.verify(tourRepository, times(1)).save(reservation);
    }

    @Test
    public void testDeleteById() {
        // Arrange
        LocalDateTime now = LocalDateTime.now();
        int tourId = 1;
        Tour tour = new Tour(1, "tour 1", 1.2, 500.0f, 400.0f, "peru", now, "image", "descripcion 1", true, agency, activities, reservations, toursReviews);
        tour.setId(tourId);
        when(tourRepository.existsById(tourId)).thenReturn(true);

        // Act
        boolean result = tourService.deleteById(tourId);

        // Assert
        assertTrue(result);
        verify(tourRepository, times(1)).existsById(tourId);
        verify(tourRepository, times(1)).deleteById(tourId);
    }
}
