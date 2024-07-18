package org.example.room;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class RoomTest {

    @Test
    void testCreateRoom() {
        //given
        Room room = new Room(32, 4, "double", 380.50);

        //then
        assertEquals(32, room.getNumber());
        assertEquals(4, room.getBeds());
        assertEquals("double", room.getTypeRoom());
        assertEquals(380.50, room.getPricePerNight());
    }


}

