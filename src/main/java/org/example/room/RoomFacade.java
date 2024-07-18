package org.example.room;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomFacade {
    private RoomRepository roomRepository;

    public RoomFacade(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public void addRoom(int number, int beds,String typeRoom, double pricePerNight) {
        Room room = new Room(number, beds,typeRoom, pricePerNight);
        roomRepository.addRoom(room);
    }
    public boolean removeRoom(int roomNumber) {
        return roomRepository.removeRoom(roomNumber);
    }

    public void bookRoom(int roomNumber) {
        Room room = roomRepository.findRoomByNumber(roomNumber);
        if (room != null && room.isAvailable()) {
            room.book();
        } else {
            System.out.println("Room " + roomNumber + " is not available.");
        }
    }

    public List<Room> getAvailableRooms() {
        return roomRepository.getAvailableRooms();
    }
}