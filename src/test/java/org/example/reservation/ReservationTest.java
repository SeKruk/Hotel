package org.example.reservation;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReservationTest {

    @Test
    void testAddReservation(){
        //given
        LocalDate startDate = LocalDate.of(2023, 5, 28);
        LocalDate endDate = LocalDate.of(2023, 5, 29);
        Reservation reservation = new Reservation(432432, 5, "Marriott", 5432, startDate, endDate);

        //then
        assertEquals(432432, reservation.getReservationId());
        assertEquals(5, reservation.getRoomNumber());
        assertEquals("Marriott", reservation.getHotelName());
        assertEquals(5432, reservation.getGuestIdNumber());
        assertEquals(startDate, reservation.getStartDate());
        assertEquals(endDate, reservation.getEndDate());
    }

}
