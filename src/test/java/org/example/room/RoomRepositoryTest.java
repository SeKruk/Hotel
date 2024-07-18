package org.example.room;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RoomRepositoryTest {

    @Test
    void testAddRoom(){
        //given
        RoomRepository repository = new RoomRepository();
        Room room = new Room(32, 4, "double", 380.50);

        //when
        repository.addRoom(room);

        //then
        assertEquals(1, repository.getAllRooms().size());
    }

    @Test
    void testRemoveRoom(){
        //given
        RoomRepository repository = new RoomRepository();
        Room room = new Room(32, 4, "double", 380.50);

        //when
        repository.addRoom(room);
        boolean removed = repository.removeRoom(32);
        assertTrue(removed);

        //then
        assertNull(repository.findRoomByNumber(32));


    }

    @Test
    void testFindRoomByNumber(){
            //given
            RoomRepository repository = new RoomRepository();
            Room room = new Room(32, 4, "double", 380.50);

            //when
            repository.addRoom(room);
            Room foundRoom = repository.findRoomByNumber(32);

            //then
            assertEquals(32, foundRoom.getNumber());
    }

    @Test
    void testGetAvailableRooms(){
            // given
            RoomRepository repository = new RoomRepository();
            Room room1 = new Room(32, 4, "double", 380.50);
            Room room2 = new Room(35, 5, "double", 450.50);

            //when
            room2.book();
            repository.addRoom(room1);
            repository.addRoom(room2);

            //then
            List<Room> availableRooms = repository.getAvailableRooms();
            assertEquals(1, availableRooms.size());
            assertEquals(32, availableRooms.get(0).getNumber());
    }

}
