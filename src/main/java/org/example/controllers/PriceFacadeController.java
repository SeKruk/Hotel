package org.example.controllers;

import org.example.price.Price;
import org.example.price.PriceFacade;
import org.example.reservation.ReservationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@RestController
@RequestMapping("/api/prices")

public class PriceFacadeController {

private final PriceFacade priceFacade;
    @Autowired
    public PriceFacadeController(PriceFacade priceFacade) {
        this.priceFacade = priceFacade;
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addPrice(
            @RequestParam String nameHotel,
            @RequestParam int room,
            @RequestParam double costs,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate
            ){
        priceFacade.addPrice(nameHotel, room, costs, startDate, endDate);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Void> removePrice(
            @RequestParam String nameHotel,
            @RequestParam int room
    ){
        boolean removed = priceFacade.removePricee(nameHotel,room);
        if(removed){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/hotel")
    public ResponseEntity<Price> findPriceByHoel(@RequestParam String nameHotel){
        Price price = priceFacade.findPriceByHotel(nameHotel);
        return Optional.ofNullable(price)
                .map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

@GetMapping("/roomAndDate")
    public ResponseEntity<Price> findPriceByRoomAndDate(
            @RequestParam int room,
            @RequestParam LocalDate date
            ){
    Price price = priceFacade.findPriceByRoomAndDate(room, date);
    return Optional.ofNullable(price)
            .map(p -> new ResponseEntity<>(p, HttpStatus.OK))
            .orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
}


}
