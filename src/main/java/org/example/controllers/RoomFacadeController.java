package org.example.controllers;

import org.example.room.Room;
import org.example.room.RoomFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomFacadeController {

    private final RoomFacade roomFacade;
@Autowired
    public RoomFacadeController(RoomFacade roomFacade) {
        this.roomFacade = roomFacade;
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addRoom(
            @RequestParam int number,
            @RequestParam int beds,
            @RequestParam String typeRoom,
            @RequestParam double pricePerNight
    ){
    roomFacade.addRoom(number, beds, typeRoom, pricePerNight);
    return new ResponseEntity<>(HttpStatus.CREATED);
    }

  @DeleteMapping("/delete{roomNumber}")
  public ResponseEntity<Void> deleteRoom (
          @PathVariable int roomNumber
  ){
    boolean removed = roomFacade.removeRoom(roomNumber);
    if(removed){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }else{
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

  }

    @PutMapping("/book/{roomNumber}")
    public ResponseEntity<Void> bookRoom(@PathVariable int roomNumber) {
        roomFacade.bookRoom(roomNumber);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/available")
    public ResponseEntity<List<Room>> showAvailableRooms() {
        List<Room> availableRooms = roomFacade.getAvailableRooms();
        if (availableRooms.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(availableRooms, HttpStatus.OK);
        }
    }
}
