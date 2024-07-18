package org.example.controllers;

import org.example.reservation.ReservationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/reservations")

public class ReservationFacadeController {
    private final ReservationFacade reservationFacade;
    @Autowired
    public ReservationFacadeController(ReservationFacade reservationFacade) {
        this.reservationFacade = reservationFacade;
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addReservation(
            @RequestParam int reservationID,
            @RequestParam int roomNumber,
            @RequestParam String hotelName,
            @RequestParam int guestIdNumber,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate
            ){
        reservationFacade.addReservation(reservationID,roomNumber,hotelName,guestIdNumber,startDate,endDate);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
   @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> removeReservation(@PathVariable int reservationId){
        boolean removed = reservationFacade.removeReservation(reservationId);
        if(removed){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
   }

}
