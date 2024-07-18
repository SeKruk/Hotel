package org.example.room;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


class RoomFacadeTest {
    @Test

    void testAddRoom() {
        // given
        RoomRepository repository = new RoomRepository();
        RoomFacade facade = new RoomFacade(repository);


        // when
        facade.addRoom(32,5,"double", 360);

        // then
        assertEquals(1, repository.getAllRooms().size());
    }
    @Test
    void testRemoveRoom(){
            //GIVEN
            RoomRepository repository = new RoomRepository();
            RoomFacade facade = new RoomFacade(repository);

            //when
            facade.addRoom(5,3,"double",350.30);
            boolean removed = facade.removeRoom(5);
            assertTrue(removed);

            //then
            assertNull(repository.findRoomByNumber(5));
    }

    @Test
    void testBookRoom(){
            ///GIVEN
            RoomRepository repository = new RoomRepository();
            RoomFacade facade = new RoomFacade(repository);
            facade.addRoom(5,3,"double",350.30);

            //when
            facade.bookRoom(5);

            //then
            assertFalse(repository.findRoomByNumber(5).isAvailable());
    }


}

