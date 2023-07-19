package com.go2climb.app.testing.service;

import com.go2climb.app.tour.domain.model.entity.Tour;
import com.go2climb.app.tour.domain.persistence.TourRepository;
import com.go2climb.app.tourist.domain.model.entity.Tourist;
import com.go2climb.app.toursreviews.domain.model.entity.ToursReviews;
import com.go2climb.app.toursreviews.domain.persistence.ToursReviewsRepository;
import com.go2climb.app.toursreviews.service.ToursReviewsServiceImpl;
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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ToursReviewServiceTest {
    @InjectMocks
    private ToursReviewsServiceImpl toursReviewsService;

    @Mock
    private ToursReviewsRepository toursReviewsRepository;

    @Mock
    private Tourist tourist;

    @Mock
    private Tour tour;

    @Mock
    private TourRepository tourRepository;

    @Test
    public void testGetAll() {
        Date now = new Date();
        ToursReviews toursReviews1 = new ToursReviews(1L, now, "Comment 1", 3.0, tourist, tour);
        ToursReviews toursReview2 = new ToursReviews(2L, now, "Comment 2", 4.0, tourist, tour);

        when(toursReviewsRepository.findAll()).thenReturn(List.of(toursReviews1, toursReview2));

        List<ToursReviews> toursReviews = toursReviewsService.getAll();

        assertEquals(2, toursReviews.size());
        assertEquals(toursReviews1, toursReviews.get(0));
        assertEquals(toursReview2, toursReviews.get(1));

        verify(toursReviewsRepository, times(1)).findAll();
    }

    @Test
    public void testGetById() {
        Date now = new Date();
        ToursReviews toursReviews = new ToursReviews(1L, now, "Comment 1", 3.0, tourist, tour);
        Mockito.when(toursReviewsRepository.existsById(1)).thenReturn(true);
        Mockito.when(toursReviewsRepository.findById(1)).thenReturn(Optional.of(toursReviews));

        Optional<ToursReviews> result = toursReviewsService.getById(1);

        assertTrue(result.isPresent());
        Assertions.assertEquals(toursReviews, result.get());

        // Verificar que se llamó al método del repositorio
        Mockito.verify(toursReviewsRepository, times(1)).existsById(1);
        Mockito.verify(toursReviewsRepository, times(1)).findById(1);
    }

    @Test
    public void testSave() {
        Date now = new Date();
        ToursReviews toursReviews = new ToursReviews(1L, now, "Comment 1", 3.0, tourist, tour);

        Mockito.when(toursReviewsRepository.save(Mockito.any(ToursReviews.class))).thenReturn(toursReviews);
        Mockito.when(tourRepository.getById(Mockito.anyInt())).thenReturn(tour);

        ToursReviews savedReviews = toursReviewsService.Save(toursReviews);

        Assertions.assertEquals(toursReviews.getId(), savedReviews.getId());
        Assertions.assertEquals(toursReviews.getComment(), savedReviews.getComment());
        Assertions.assertEquals(toursReviews.getScore(), savedReviews.getScore());

        Mockito.verify(toursReviewsRepository, Mockito.times(1)).save(Mockito.any(ToursReviews.class));
        Mockito.verify(tourRepository, Mockito.times(1)).getById(Mockito.anyInt());
        Mockito.verify(tourRepository, Mockito.times(1)).save(Mockito.any(Tour.class));
    }

    @Test
    public void testUpdate() {
        Date now = new Date();
        ToursReviews toursReviews = new ToursReviews(1L, now, "Comment 1", 3.0, tourist, tour);

        Mockito.when(toursReviewsRepository.save(toursReviews)).thenReturn(toursReviews);

        ToursReviews result = toursReviewsService.Update(toursReviews);

        Assertions.assertEquals(toursReviews, result);

        Mockito.verify(toursReviewsRepository, times(1)).save(toursReviews);
    }

    @Test
    public void testDeleteById() {
        // Arrange
        long reviewId = 1;
        when(toursReviewsRepository.existsById((int)reviewId)).thenReturn(true);

        // Act
        boolean result = toursReviewsService.deleteById((int)reviewId);

        // Assert
        assertTrue(result);
        verify(toursReviewsRepository, times(1)).existsById((int)reviewId);
        verify(toursReviewsRepository, times(1)).deleteById((int)reviewId);
    }
}
