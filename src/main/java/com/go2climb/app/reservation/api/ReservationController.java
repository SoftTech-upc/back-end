package com.go2climb.app.reservation.api;

import com.go2climb.app.reservation.domain.model.entity.Reservation;
import com.go2climb.app.reservation.domain.service.ReservationService;
import com.go2climb.app.reservation.mapping.ReservationMapper;
import com.go2climb.app.reservation.resource.CreateReservationResource;
import com.go2climb.app.reservation.resource.ReservationResource;
import com.go2climb.app.reservation.resource.UpdateReservationResource;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reservations")
@AllArgsConstructor
public class ReservationController {
  private final ReservationService reservationService;
  private final ReservationMapper mapper;

//  @PostMapping
//  public ReservationResource save(@RequestBody CreateReservationResource resource) {
//    return mapper.toResource(reservationService.save(mapper.toModel(resource)));
//  }

  @PostMapping
  public ReservationResource save(@RequestBody CreateReservationResource resource) {
    return mapper.toResource(reservationService.save(mapper.toModel(resource)));
  }

  @GetMapping
  public List<Reservation> fetchAll() {
    return reservationService.fetchAll();
  }

  @GetMapping("{id}")
  public ReservationResource fetchId(@PathVariable Integer id) {
    //return studentService.fetchById(id).get();
    return this.mapper.toResource(reservationService.fetchById(id).get());
  }

  @PutMapping("{id}")
  public ResponseEntity<ReservationResource> update(@PathVariable Integer id,
                                                    @RequestBody UpdateReservationResource resource){
    if (id.equals(resource.getId())) {
      ReservationResource studentResource = mapper.toResource(
        reservationService.update(mapper.toModel(resource)));

      return new ResponseEntity<>(studentResource, HttpStatus.OK);
    } else {
      return ResponseEntity.badRequest().build();
    }
  }

  @DeleteMapping("{id}")
  public ResponseEntity<?> delete(@PathVariable Integer id) {
    if(reservationService.deleteById(id)){
      return ResponseEntity.ok().build(); //Devolver de forma directa - lambda
      //return new ResponseEntity<>(HttpStatus.OK); //Devoluicon con instanciación
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
