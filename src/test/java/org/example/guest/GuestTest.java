package org.example.guest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GuestTest {
    @Test
    void shouldCreateGuest(){
        Guest guest = new Guest("Jan", "Nowak", "nowak@wfs.sd", 123456789, 12345, "admin321!");
        assertEquals("Jan", guest.getName());
        assertEquals("Nowak", guest.getSurname());
        assertEquals("nowak@wfs.sd", guest.getEmail());
        assertEquals(123456789, guest.getPhone());
        assertEquals(12345, guest.getId());
        assertEquals("admin321!", guest.getPassword());



    }
}
