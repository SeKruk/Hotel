package org.example.guest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GuestFacadeTest {

    @Test
    void testAddGuest(){
        //given
        GuestRepository repository = new GuestRepository();
        GuestFacade facade = new GuestFacade(repository);

        //when
        facade.addGuest("Jan", "Nowak", "nowak@wfs.sd", 123456789, 12345, "admin321!");

        //then
        assertEquals(1, repository.getAllGuests().size());

    }

    @Test
    void testRemoveGuest(){
        //given
        GuestRepository repository = new GuestRepository();
        GuestFacade facade = new GuestFacade(repository);

        //when
        facade.addGuest("Jan", "Nowak", "nowak@wfs.sd", 123456789, 12345, "admin321!");
        boolean removed = facade.removeGuest(12345);
        assertTrue(removed);

        //then
        assertNull(repository.findGuestById(12345));
    }
}
