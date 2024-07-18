package org.example.reservation;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ReservationFacadeTest {

    @Test
    void testAddReservation(){
        //given
        ReservationRepository repository = new ReservationRepository();
        ReservationFacade facade = new ReservationFacade(repository);
        LocalDate startDate = LocalDate.of(2023, 5, 28);
        LocalDate endDate = LocalDate.of(2023, 5, 29);

        //when
        facade.addReservation(432432, 5, "Marriott", 5432, startDate, endDate);

        //then
        assertEquals(1, repository.getAllReservations().size());

    }

    @Test
    void testRemoveReservation(){
        ReservationRepository repository = new ReservationRepository();
        ReservationFacade facade = new ReservationFacade(repository);
        LocalDate startDate = LocalDate.of(2023, 5, 28);
        LocalDate endDate = LocalDate.of(2023, 5, 29);

        //when
        facade.addReservation(432432, 5, "Marriott", 5432, startDate, endDate);
        boolean removed = facade.removeReservation(432432);
        assertTrue(removed);

        //then
        assertNull(repository.findReservationById(432432));

    }

}
