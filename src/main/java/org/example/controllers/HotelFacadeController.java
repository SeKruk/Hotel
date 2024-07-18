package org.example.controllers;

import org.example.hotel.Hotel;
import org.example.hotel.HotelFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/hotels")
public class HotelFacadeController {

    private final HotelFacade hotelFacade;

    @Autowired
    public HotelFacadeController(HotelFacade hotelFacade) {
        this.hotelFacade = hotelFacade;
    }

    @PostMapping("/add")
    public ResponseEntity<UUID> addHotel(@RequestParam String name, @RequestParam String country, @RequestParam String city) {
        UUID hotelId = hotelFacade.addHotel(name, country, city);
        return new ResponseEntity<>(hotelId, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable UUID id) {
        hotelFacade.deleteHotel(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotel(@PathVariable UUID id) {
        Hotel hotel = hotelFacade.pobierz(id);
        if (hotel != null) {
            return new ResponseEntity<>(hotel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}