package com.go2climb.app.testing.service;

import com.go2climb.app.activity.domain.model.entity.Activity;
import com.go2climb.app.activity.domain.persistence.ActivityRepository;
import com.go2climb.app.activity.service.ActivityServiceImpl;
import com.go2climb.app.tour.domain.model.entity.Tour;
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
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class ActivityServiceTest {

    @InjectMocks
    private ActivityServiceImpl activityService;

    @Mock
    private ActivityRepository activityRepository;

    @Mock
    private Tour tour;

    @Test
    public void testGetAll() {
        Activity activity1 = new Activity(1, "Actividad 1", "Descripción 1", tour);
        Activity activity2 = new Activity(2, "Actividad 2", "Descripción 2", tour);

        when(activityRepository.findAll()).thenReturn(List.of(activity1, activity2));

        List<Activity> activities = activityService.getAll();

        assertEquals(2, activities.size());
        assertEquals(activity1, activities.get(0));
        assertEquals(activity2, activities.get(1));

        verify(activityRepository, times(1)).findAll();
    }

    @Test
    public void testGetById() {
        Activity activity = new Activity(1, "Actividad 1", "Descripción 1", tour);
        Mockito.when(activityRepository.existsById(1)).thenReturn(true);
        Mockito.when(activityRepository.findById(1)).thenReturn(Optional.of(activity));

        Optional<Activity> result = activityService.getById(1);

        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(activity, result.get());

        // Verificar que se llamó al método del repositorio
        Mockito.verify(activityRepository, times(1)).existsById(1);
        Mockito.verify(activityRepository, times(1)).findById(1);
    }

    @Test
    public void testSave() {
        Activity expected = new Activity(1, "Actividad 1", "Descripción 1", tour);
        Activity activity = new Activity(1, "Actividad 1", "Descripción 1", tour);

        Mockito.when( activityRepository.save(Mockito.any(Activity.class)) )
                .thenReturn( activity );

        Activity actual = activityService.save(new Activity(null,  "Actividad 1", "Descripción 1", tour));

        Assertions.assertEquals(expected.getId(),actual.getId());
        Assertions.assertEquals(expected.getName(),actual.getName());
        Assertions.assertEquals(expected.getDescription(),actual.getDescription());
    }

    @Test
    public void testUpdate() {
        Activity activity = new Activity(1, "Actividad 1", "Descripción 1", tour);

        Mockito.when(activityRepository.save(activity)).thenReturn(activity);

        Activity result = activityService.update(activity);

        Assertions.assertEquals(activity, result);

        Mockito.verify(activityRepository, times(1)).save(activity);
    }

    @Test
    public void testDeleteById() {
        boolean expected = true;
        boolean deleted = true;

        Mockito.when( activityService.deleteById(Mockito.anyInt()))
                .thenReturn( deleted );

        boolean actual = activityService.deleteById(1);

        Assertions.assertEquals(expected,actual);
    }

}
