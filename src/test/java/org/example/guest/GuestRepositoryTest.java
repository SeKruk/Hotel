package org.example.guest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GuestRepositoryTest {
    @Test
    void shouldAddGuest(){
        //given
        GuestRepository repository = new GuestRepository();
        Guest guest = new Guest("Jan", "Nowak", "nowak@wfs.sd", 123456789, 12345, "admin321!");

        // when
        repository.addGuest(guest);

        // then
        assertEquals(1, repository.getAllGuests().size());
    }

    @Test
    void shouldRemoveGuest(){
        //given
        GuestRepository repository = new GuestRepository();
        Guest guest = new Guest("Jan", "Nowak", "nowak@wfs.sd", 123456789, 12345, "admin321!");

        //when
        repository.addGuest(guest);
        boolean removed = repository.removeGuest(12345);
        assertTrue(removed);

        //then
        assertNull(repository.findGuestById(12345));

    }
    @Test
    void testFindGuestById(){
        //given
        GuestRepository repository = new GuestRepository();
        Guest guest = new Guest("Jan", "Nowak", "nowak@wfs.sd", 123456789, 12345, "admin321!");

        //when
        repository.addGuest(guest);
        Guest foundGuest = repository.findGuestById(12345);

        //then
        assertEquals(12345, foundGuest.getId());

    }
}