package org.example.controllers;


import org.example.guest.GuestFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/guests")

public class GuestFacadeController {

    private final GuestFacade guestFacade;

    @Autowired
    public GuestFacadeController(GuestFacade guestFacade) {
        this.guestFacade = guestFacade;
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addGuest(
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String email,
            @RequestParam int phone,
            @RequestParam int id,
            @RequestParam String password
    ) {
        guestFacade.addGuest(name, surname, email, phone, id, password);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteGuest(@PathVariable int id){
        boolean removed = guestFacade.removeGuest(id);
        if(removed){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}







