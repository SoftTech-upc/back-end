package com.go2climb.app.testing.service;

import com.go2climb.app.agencyreviews.domain.model.entity.AgencyReview;
import com.go2climb.app.reservation.domain.model.entity.Reservation;
import com.go2climb.app.tourist.domain.model.entity.Tourist;
import com.go2climb.app.tourist.domain.persistence.TouristRepository;
import com.go2climb.app.tourist.service.TouristServiceImpl;
import com.go2climb.app.toursreviews.domain.model.entity.ToursReviews;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TouristServiceTest {
    @InjectMocks
    private TouristServiceImpl touristService;

    @Mock
    private TouristRepository touristRepository;

    @Mock
    private List<Reservation> reservations;

    @Mock
    private List<AgencyReview> agencyReviews;

    @Mock
    private List<ToursReviews> toursReviews;

    @Test
    public void testGetAll() {
        Tourist tourist1 = new Tourist(1, "name", "lastname","abc@mail.com", "999999999", "123456", "photo", reservations, agencyReviews, toursReviews, "tourist");
        Tourist tourist2 = new Tourist(2, "name 2", "lastname 2","def@mail.com", "999999998", "123456", "photo", reservations, agencyReviews, toursReviews, "tourist");

        when(touristRepository.findAll()).thenReturn(List.of(tourist1, tourist2));

        List<Tourist> tourists = touristService.getAll();

        assertEquals(2, tourists.size());
        assertEquals(tourist1, tourists.get(0));
        assertEquals(tourist2, tourists.get(1));

        verify(touristRepository, times(1)).findAll();
    }

    @Test
    public void testGetById() {
        Tourist tourist = new Tourist(1, "name", "lastname","abc@mail.com", "999999999", "123456", "photo", reservations, agencyReviews, toursReviews, "tourist");
        Mockito.when(touristRepository.existsById(1)).thenReturn(true);
        Mockito.when(touristRepository.findById(1)).thenReturn(Optional.of(tourist));

        Optional<Tourist> result = touristService.getById(1);

        assertTrue(result.isPresent());
        Assertions.assertEquals(tourist, result.get());

        // Verificar que se llamó al método del repositorio
        Mockito.verify(touristRepository, times(1)).existsById(1);
        Mockito.verify(touristRepository, times(1)).findById(1);
    }

    @Test
    public void testSave() {
        Tourist expected = new Tourist(1, "name", "lastname","abc@mail.com", "999999999", "123456", "photo", reservations, agencyReviews, toursReviews, "tourist");
        Tourist tourist = new Tourist(1, "name", "lastname","abc@mail.com", "999999999", "123456", "photo", reservations, agencyReviews, toursReviews, "tourist");

        Mockito.when( touristRepository.save(Mockito.any(Tourist.class)) )
                .thenReturn( tourist );

        Tourist actual = touristService.save(new Tourist(1, "name", "lastname","abc@mail.com", "999999999", "123456", "photo", reservations, agencyReviews, toursReviews, "tourist"));

        Assertions.assertEquals(expected.getId(),actual.getId());
        Assertions.assertEquals(expected.getName(),actual.getName());
        Assertions.assertEquals(expected.getLastName(),actual.getLastName());
        Assertions.assertEquals(expected.getEmail(),actual.getEmail());
        Assertions.assertEquals(expected.getPhoneNumber(),actual.getPhoneNumber());
        Assertions.assertEquals(expected.getPassword(),actual.getPassword());
        Assertions.assertEquals(expected.getPhoto(),actual.getPhoto());
    }

    @Test
    public void testUpdate() {
        Tourist tourist = new Tourist(1, "name", "lastname","abc@mail.com", "999999999", "123456", "photo", reservations, agencyReviews, toursReviews, "tourist");

        Mockito.when(touristRepository.save(tourist)).thenReturn(tourist);

        Tourist result = touristService.update(tourist);

        Assertions.assertEquals(tourist, result);

        Mockito.verify(touristRepository, times(1)).save(tourist);
    }

    @Test
    public void testDeleteById() {
        // Arrange
        int touristId = 1;
        when(touristRepository.existsById(touristId)).thenReturn(true);

        // Act
        boolean result = touristService.deleteById(touristId);

        // Assert
        assertTrue(result);
        verify(touristRepository, times(1)).existsById(touristId);
        verify(touristRepository, times(1)).deleteById(touristId);
    }
}
