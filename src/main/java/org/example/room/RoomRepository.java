package org.example.room;


import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class RoomRepository {
    private List<Room> rooms;
    public RoomRepository() {
        this.rooms = new ArrayList<>();
    }
    public void addRoom(Room room){
        rooms.add(room);
    }
    public boolean removeRoom(int roomNumber) {
        return rooms.removeIf(room -> room.getNumber() == roomNumber);
    }
    public Room findRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (room.getNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    public List<Room> getAllRooms() {
        return new ArrayList<>(rooms);
    }

    public List<Room> getAvailableRooms() {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }
}