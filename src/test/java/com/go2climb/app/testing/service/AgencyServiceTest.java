package com.go2climb.app.testing.service;

import com.go2climb.app.agency.domain.model.entity.Agency;
import com.go2climb.app.agency.domain.persistence.AgencyRepository;
import com.go2climb.app.agency.service.AgencyServiceImpl;
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
public class AgencyServiceTest {

    @InjectMocks
    private AgencyServiceImpl agencyService;

    @Mock
    private AgencyRepository agencyRepository;

    @Mock
    private List<AgencyReview> agencyReviews;

    @Mock
    private List<Tour> tours;

    @Test
    public void testGetAll() {
        Agency agency1 = new Agency(1, "Agency 1", "email 1", "999999999", "Descripción 1", "location 1", "123456789", "photo 1", 4.0, agencyReviews, tours, "12345", "agency");
        Agency agency2 = new Agency(2, "Agency 2", "email 2", "999999998", "Descripción 2", "location 2", "123456788", "photo 2", 5.0, agencyReviews, tours, "12344", "agency");

        when(agencyRepository.findAll()).thenReturn(List.of(agency1, agency2));

        List<Agency> agencies = agencyService.getAll();

        assertEquals(2, agencies.size());
        assertEquals(agency1, agencies.get(0));
        assertEquals(agency2, agencies.get(1));

        verify(agencyRepository, times(1)).findAll();
    }

    @Test
    public void testGetById() {
        Agency agency = new Agency(1, "Agency 1", "email 1", "999999999", "Descripción 1", "location 1", "123456789", "photo 1", 4.0, agencyReviews, tours, "12345", "agency");
        Mockito.when(agencyRepository.existsById(1)).thenReturn(true);
        Mockito.when(agencyRepository.findById(1)).thenReturn(Optional.of(agency));

        Optional<Agency> result = agencyService.getById(1);

        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(agency, result.get());

        // Verificar que se llamó al método del repositorio
        Mockito.verify(agencyRepository, times(1)).existsById(1);
        Mockito.verify(agencyRepository, times(1)).findById(1);
    }

    @Test
    public void testSave() {
        Agency expected = new Agency(1, "Agency 1", "email 1", "999999999", "Descripción 1", "location 1", "123456789", "photo 1", 4.0, agencyReviews, tours, "12345", "agency");
        Agency agency = new Agency(1, "Agency 1", "email 1", "999999999", "Descripción 1", "location 1", "123456789", "photo 1", 4.0, agencyReviews, tours, "12345", "agency");

        Mockito.when( agencyRepository.save(Mockito.any(Agency.class)) )
                .thenReturn( agency );

        Agency actual = agencyService.save(new Agency(1, "Agency 1", "email 1", "999999999", "Descripción 1", "location 1", "123456789", "photo 1", 4.0, agencyReviews, tours, "12345", "agency"));

        Assertions.assertEquals(expected.getId(),actual.getId());
        Assertions.assertEquals(expected.getName(),actual.getName());
        Assertions.assertEquals(expected.getDescription(),actual.getDescription());
    }

    @Test
    public void testUpdate() {
        Agency agency = new Agency(1, "Agency 1", "email 1", "999999999", "Descripción 1", "location 1", "123456789", "photo 1", 4.0, agencyReviews, tours, "12345", "agency");

        Mockito.when(agencyRepository.save(agency)).thenReturn(agency);

        Agency result = agencyService.update(agency);

        Assertions.assertEquals(agency, result);

        Mockito.verify(agencyRepository, times(1)).save(agency);
    }

    @Test
    public void testDeleteById() {
        boolean expected = true;
        boolean deleted = true;

        Mockito.when( agencyService.deleteById(Mockito.anyInt()))
                .thenReturn( deleted );

        boolean actual = agencyService.deleteById(1);

        Assertions.assertEquals(expected,actual);
    }
}
