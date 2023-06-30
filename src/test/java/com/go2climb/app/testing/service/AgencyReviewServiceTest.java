package com.go2climb.app.testing.service;

import com.go2climb.app.activity.domain.model.entity.Activity;
import com.go2climb.app.activity.domain.persistence.ActivityRepository;
import com.go2climb.app.activity.service.ActivityServiceImpl;
import com.go2climb.app.agency.domain.model.entity.Agency;
import com.go2climb.app.agencyreviews.domain.model.entity.AgencyReview;
import com.go2climb.app.agencyreviews.domain.persistence.AgencyReviewRepository;
import com.go2climb.app.agencyreviews.service.AgencyReviewServiceImpl;
import com.go2climb.app.tour.domain.model.entity.Tour;
import com.go2climb.app.tourist.domain.model.entity.Tourist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class AgencyReviewServiceTest {
    @InjectMocks
    private AgencyReviewServiceImpl agencyReviewService;

    @Mock
    private AgencyReviewRepository agencyReviewRepository;

    @Mock
    private Agency agency;

    @Mock
    private Tourist tourist;

    @Test
    public void testGetAll() {
        AgencyReview agencyReview1 = new AgencyReview(1, LocalDateTime.now(), "Comment 1", 3.0f, 4.0f, 5, 2, agency, tourist);
        AgencyReview agencyReview2 = new AgencyReview(2, LocalDateTime.now(), "Comment 2", 4.0f, 3.0f, 2, 5, agency, tourist);

        when(agencyReviewRepository.findAll()).thenReturn(List.of(agencyReview1, agencyReview2));

        List<AgencyReview> agencyReviews = agencyReviewService.fetchAll();

        assertEquals(2, agencyReviews.size());
        assertEquals(agencyReview1, agencyReviews.get(0));
        assertEquals(agencyReview2, agencyReviews.get(1));

        verify(agencyReviewRepository, times(1)).findAll();
    }

    @Test
    public void testGetById() {
        AgencyReview agencyReview = new AgencyReview(1, LocalDateTime.now(), "Comment 1", 3.0f, 4.0f, 5, 2, agency, tourist);
        Mockito.when(agencyReviewRepository.existsById(1)).thenReturn(true);
        Mockito.when(agencyReviewRepository.findById(1)).thenReturn(Optional.of(agencyReview));

        Optional<AgencyReview> result = agencyReviewService.fecthById(1);

        assertTrue(result.isPresent());
        Assertions.assertEquals(agencyReview, result.get());

        // Verificar que se llamó al método del repositorio
        Mockito.verify(agencyReviewRepository, times(1)).existsById(1);
        Mockito.verify(agencyReviewRepository, times(1)).findById(1);
    }

    @Test
    public void testSave() {
        LocalDateTime now = LocalDateTime.now();
        AgencyReview expected = new AgencyReview(1, now, "Comment 1", 3.0f, 4.0f, 5, 2, agency, tourist);
        AgencyReview agencyReview = new AgencyReview(1, now, "Comment 1", 3.0f, 4.0f, 5, 2, agency, tourist);

        Mockito.when( agencyReviewRepository.save(Mockito.any(AgencyReview.class)) )
                .thenReturn( agencyReview );

        AgencyReview actual = agencyReviewService.save(new AgencyReview(1, LocalDateTime.now(), "Comment 1", 3.0f, 4.0f, 5, 2, agency, tourist));

        Assertions.assertEquals(expected.getId(),actual.getId());
        Assertions.assertEquals(expected.getCreatedAt(),actual.getCreatedAt());
        Assertions.assertEquals(expected.getComment(),actual.getComment());
        Assertions.assertEquals(expected.getProfessionalismScore(),actual.getProfessionalismScore());
        Assertions.assertEquals(expected.getSecurityScore(),actual.getSecurityScore());
        Assertions.assertEquals(expected.getQualityScore(),actual.getQualityScore());
        Assertions.assertEquals(expected.getCostScore(),actual.getCostScore());
        Assertions.assertEquals(expected.getAgency(),actual.getAgency());
        Assertions.assertEquals(expected.getTourist(),actual.getTourist());
    }

    @Test
    public void testUpdate() {
        AgencyReview agencyReview = new AgencyReview(1, LocalDateTime.now(), "Comment 1", 3.0f, 4.0f, 5, 2, agency, tourist);

        Mockito.when(agencyReviewRepository.save(agencyReview)).thenReturn(agencyReview);

        AgencyReview result = agencyReviewService.update(agencyReview);

        Assertions.assertEquals(agencyReview, result);

        Mockito.verify(agencyReviewRepository, times(1)).save(agencyReview);
    }

    @Test
    public void testDeleteById() {
        // Simular el comportamiento del repositorio
        AgencyReview agencyReview = new AgencyReview(1, LocalDateTime.now(), "Comentario", 3.0f, 4.0f, 5, 2, agency, tourist);
        Mockito.when(agencyReviewRepository.findById(1)).thenReturn(Optional.of(agencyReview));
        Mockito.doNothing().when(agencyReviewRepository).deleteById(1);

        // Ejecutar el método a probar
        boolean result = agencyReviewService.deleteById(1);

        // Verificar el resultado y las interacciones con el repositorio
        Assertions.assertTrue(result);
        Mockito.verify(agencyReviewRepository).findById(1);
        Mockito.verify(agencyReviewRepository).deleteById(1);
    }

}
